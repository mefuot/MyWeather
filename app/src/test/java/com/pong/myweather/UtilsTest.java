package com.pong.myweather;

import com.pong.myweather.utils.Utils;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by USER on 27/2/2560.
 */

public class UtilsTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void capitalize_firstLetterShouldCapitalize(){
        assertEquals(Utils.capitalize("abcdefg"),"Abcdefg");
    }

    @Test
    public void capitalize_shouldReturnNull_ifPassNullAsArgument(){
        assertNull(Utils.capitalize("abcdefg"),null);
    }

    @Test
    public void capitalize_shouldDoNothing_ifPassEmptyString(){
        assertEquals(Utils.capitalize(""),"");
    }

    @Test
    public void showAlertPopup_shouldThrowError_ifPassNullContext() throws NullPointerException {
        thrown.expect(NullPointerException.class);

        Utils.showAlertPopup(null,"test");
    }

    @Test
    public void containsIgnoreCase_shouldReturnTrue_ifArrayContainTargetString(){
        ArrayList<String> list = new ArrayList<>();
        list.add("string");

        assertTrue(Utils.containsIgnoreCase(list,"string"));
    }

    @Test
    public void containsIgnoreCase_shouldReturnFalse_ifArrayNotContainTargetString(){
        ArrayList<String> list = new ArrayList<>();
        list.add("string");

        assertFalse(Utils.containsIgnoreCase(list,"exclude_string"));
    }

    @Test
    public void containsIgnoreCase_shouldReturnTrue_ifArrayContainTargetString_withIgnoreCase(){
        ArrayList<String> list = new ArrayList<>();
        list.add("SOURCE_UPPERCASE");
        list.add("Source_Capitalize");
        list.add("source_lowercase");

        assertTrue(Utils.containsIgnoreCase(list,"source_uppercase"));
        assertTrue(Utils.containsIgnoreCase(list,"source_capitalize"));
        assertTrue(Utils.containsIgnoreCase(list,"SOURCE_LOWERCASE"));
    }

    @Test
    public void containsIgnoreCase_shouldReturnFalse_ifArrayIsEmpty(){
        ArrayList<String> list = new ArrayList<>();
        assertFalse(Utils.containsIgnoreCase(list,"string"));
    }

    @Test
    public void containsIgnoreCase_shouldReturnFalse_ifArrayIsNull(){
        assertFalse(Utils.containsIgnoreCase(null,"string"));
    }

    @Test
    public void containsIgnoreCase_shouldReturnFalse_ifTargetStringIsNull(){
        ArrayList<String> list = new ArrayList<>();
        list.add("string");
        assertFalse(Utils.containsIgnoreCase(list,null));
    }
}
