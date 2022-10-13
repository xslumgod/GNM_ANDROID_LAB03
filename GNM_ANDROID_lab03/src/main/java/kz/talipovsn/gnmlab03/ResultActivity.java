package kz.talipovsn.gnmlab03;

import static kz.talipovsn.gnmlab03.R.color.colorAccent;
import static kz.talipovsn.gnmlab03.R.drawable.abc_edit_text_material;
import static kz.talipovsn.gnmlab03.R.drawable.background2;
import static kz.talipovsn.gnmlab03.R.drawable.game;
import static kz.talipovsn.gnmlab03.R.drawable.game2;
import static kz.talipovsn.gnmlab03.R.drawable.game3;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ResultActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // Переменная доступа к компоненту окна с инициализацией
        EditText editText = findViewById(R.id.editText);
        View textView = findViewById(R.id.line_layout);
                // Запрет на редактирование в компоненте "editText"
        editText.setKeyListener(null);

        // Очистка данных в компоненте "editText"
        editText.setText("");

        // Добавление данных в компонент "editText"
        editText.append(String.format("%s %s \n", getString(R.string.Ваш_Nickname), getIntent().getStringExtra("nick")));
        editText.append(String.format("%s %s \n", getString(R.string.Ваш_пол), getIntent().getStringExtra("gender")));
        editText.append(String.format("%s %s \n", getString(R.string.Сложность), getIntent().getStringExtra("complexity")));
        editText.append(String.format("%s %s \n", getString(R.string.Игра), getIntent().getStringExtra("game")));


        int k = (int)getIntent().getLongExtra("backgroundgameid", 0);
        System.out.println(k);

        switch (k) {
            case 0:
                textView.setBackgroundResource(game);
                break;
            case 1:
                textView.setBackgroundResource(game2);
                break;
            case 2:
                textView.setBackgroundResource(game3);
                break;
        }
    }

    // МЕТОД ДЛЯ КНОПКИ НАЗАД
    public void onBack(View v) {
        setResult(RESULT_OK);
        finish();
    }

    // МЕТОД ДЛЯ КНОПКИ ВЫХОДА
    public void onExit(View v) {
        finishAffinity();
    }

}
