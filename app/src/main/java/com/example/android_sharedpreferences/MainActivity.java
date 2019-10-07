package com.example.android_sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


/**
 * Android - Shared Preferences;
 *
 * @author Felipe Fong
 * @version 1.0
 * @see <a href="https://github.com/fefong">GitHub</a>
 * @see <a href="https://www.linkedin.com/in/felipesu">Linkedin</a>
 */
public class MainActivity extends AppCompatActivity {


    private EditText edtSharedPreference;
    private Button buttonDelete, buttonSave, buttonOpen;
    private TextView txSharedPreference;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editorSharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitializeComponent();

        btOpen(null);
    }

    /**
     * Button: Save Shared Preferences ;
     *
     * @see #btSave(View view)
     */
    public void btSave(View view) {

        if (isEmptyText()) {
            msg(getString(R.string.sharedPreferencesPleaseSetAnyText));
            return;
        }

        editorSharedPreferences.putString(getString(R.string.KEY_1), edtSharedPreference.getText().toString().trim());
        editorSharedPreferences.apply();

        msg(getString(R.string.sharedPreferencesSaved) + "\n" + getString(R.string.sharedPreferencesPressOpen));
        hideKeyboard();
    }


    /**
     * Button: Open Text Save ;
     *
     * @see #btOpen(View view)
     */
    public void btOpen(View view) {
        final String KEY = getString(R.string.KEY_1);

        if (sharedPreferences.contains(KEY)) {

            String text = sharedPreferences.getString(KEY, "");
            if (!text.equals("")) {
                txSharedPreference.setText(text);
            } else {
                msg(getString(R.string.sharedPreferencesIsNull));
                setTextEmpty();
            }

        } else {
            msg(getString(R.string.sharedPreferencesIsNull));
            setTextEmpty();
        }

    }

    /**
     * Button: Delete Shared Preference
     *
     * @see #btDelete(View view)
     */
    public void btDelete(View view) {
        editorSharedPreferences.remove(getString(R.string.KEY_1));
        editorSharedPreferences.commit();

        setTextEmpty();
        msg(getString(R.string.sharedPreferencesDelete));
    }


    /**
     * Method: InitializeComponent();
     */
    private void InitializeComponent() {
        /**
         * EditText
         */
        edtSharedPreference = findViewById(R.id.editTextSharedPreference);

        /**
         * TextView
         */
        txSharedPreference = findViewById(R.id.textViewSharedPreference);

        /**
         * Button
         */
        buttonDelete = findViewById(R.id.buttonDelete);
        buttonSave = findViewById(R.id.buttonSave);
        buttonOpen = findViewById(R.id.buttonOpen);

        /**
         *  Variables
         */
        sharedPreferences = getSharedPreferences(getString(R.string.KEY_PREFERENCE_TEXT), Context.MODE_PRIVATE);
        editorSharedPreferences = sharedPreferences.edit();
    }


    private boolean isEmptyText() {
        return edtSharedPreference.getText().toString().isEmpty() ||
                edtSharedPreference.getText().toString().equalsIgnoreCase("");
    }


    private void setTextEmpty() {
        txSharedPreference.setText(getString(R.string.sharedPreferencesIsNull));
    }


    private void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(txSharedPreference.getWindowToken(),
                InputMethodManager.RESULT_UNCHANGED_SHOWN);

    }

    private void msg(String text) {
        Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();

    }
}
