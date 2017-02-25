package com.pong.myweather.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.pong.myweather.R;
import com.pong.myweather.model.WeatherModel;
import com.pong.myweather.presenter.SearchPresenter;
import com.pong.myweather.view.SearchView;

/**
 * Created by USER on 25/2/2560.
 */

public class SearchFragment extends Fragment implements SearchView {
    public interface OnSearchWeatherListener {
        void onOpenWeatherDetail(WeatherModel model);
    }

    private EditText searchEditText;
    private SearchPresenter presenter;
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
        searchEditText = (EditText) view.findViewById(R.id.edittext_search);

        Button searchButton = (Button) view.findViewById(R.id.button_search);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!searchEditText.getText().toString().isEmpty()) {
                    showSpinner();
                    hideKeyboard();
                    presenter.loadWeatherData(getContext(), searchEditText.getText().toString());
                } else {
                    showAlertPopup("Please Enter City name.");
                }
            }
        });
    }

    @Override
    public void onSuccessLoadWeatherData(WeatherModel model) {
        dismissSpinner();
        ((OnSearchWeatherListener) getActivity()).onOpenWeatherDetail(model);
    }

    @Override
    public void onFailedLoadWeatherData(String message) {
        dismissSpinner();
        showAlertPopup(message);
    }

    private void showAlertPopup(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(message);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }

    private void showSpinner() {
        if (progress == null) {
            progress = new ProgressDialog(getActivity());
            progress.setTitle("Loading");
            progress.setMessage("Wait while loading...");
            progress.setCancelable(false); // disable dismiss by tapping outside of the dialog
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
