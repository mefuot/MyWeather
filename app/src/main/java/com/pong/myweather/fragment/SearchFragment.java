package com.pong.myweather.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import com.pong.myweather.R;
import com.pong.myweather.model.WeatherModel;
import com.pong.myweather.presenter.SearchPresenter;
import com.pong.myweather.singleton.CityManager;
import com.pong.myweather.utils.Utils;
import com.pong.myweather.view.SearchView;

/**
 * Created by USER on 25/2/2560.
 */

public class SearchFragment extends Fragment implements SearchView {
    public interface OnSearchWeatherListener {
        void onOpenWeatherDetail(WeatherModel model);
    }

    private SearchPresenter presenter;
    private AutoCompleteTextView searchAutoCompleteText;
    private ProgressDialog progress;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        presenter = new SearchPresenter(this);
        searchAutoCompleteText = (AutoCompleteTextView) view.findViewById(R.id.edittext_search);
        searchAutoCompleteText.setInputType(InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS);

        setAutoCompleteAdapter();
        setAutoCompleteListener();

        Button searchButton = (Button) view.findViewById(R.id.button_search);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!searchAutoCompleteText.getText().toString().isEmpty()) {
                    onSearchClicked(searchAutoCompleteText.getText().toString());
                } else {
                    Utils.showAlertPopup(getActivity(), "Please Enter City name.");
                }
            }
        });
    }

    private void setAutoCompleteAdapter() {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_dropdown_item_1line,
                CityManager.getInstance(getActivity()).getAllCityList());

        if (searchAutoCompleteText != null) {
            searchAutoCompleteText.setAdapter(adapter);
        }else throw new NullPointerException("searchAutoCompleteText can't be null");
    }

    private void setAutoCompleteListener() {
        if (searchAutoCompleteText != null) {
            searchAutoCompleteText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if (hasFocus) searchAutoCompleteText.showDropDown();
                }
            });

            searchAutoCompleteText.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    searchAutoCompleteText.showDropDown();
                    return false;
                }
            });

            searchAutoCompleteText.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    onSearchClicked(searchAutoCompleteText.getText().toString());
                }
            });
        }else throw new NullPointerException("searchAutoCompleteText can't be null");
    }

    private void onSearchClicked(String cityName) {
        showSpinner();
        hideKeyboard();
        presenter.loadWeatherData(getContext(), cityName);
    }

    @Override
    public void onSuccessLoadWeatherData(final WeatherModel model) {
        dismissSpinner();
        ((OnSearchWeatherListener) getActivity()).onOpenWeatherDetail(model);
        CityManager.getInstance(getActivity()).addCityName(searchAutoCompleteText.getText().toString());
    }

    @Override
    public void onFailedLoadWeatherData(String message) {
        dismissSpinner();
        Utils.showAlertPopup(getActivity(), message);
    }

    private void showSpinner() {
        if (progress == null) {
            progress = new ProgressDialog(getActivity());
            progress.setTitle("Loading");
            progress.setMessage("Wait while loading...");
            progress.setCancelable(false);
        }
        progress.show();
    }

    private void dismissSpinner() {
        if (progress != null && progress.isShowing()) progress.dismiss();
    }

    private void hideKeyboard() {
        View view = getActivity().getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
