package es.ieslavereda.mychessandroid_22_23;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TableLayout board;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TableRow row;

        board = findViewById(R.id.board);

        // Fila superior
        addTextViews();


        // Parte media
        for (int r = 1; r <= 8; r++) {
            row = new TableRow(this);
            row.addView(getTextView(""+r));

            for (int c = 'A'; c <= 'H'; c++) {
                Cell cell = new Cell(this, new Coordinate((char) c, r), null);
                cell.highlight();
                row.addView(cell);
            }

            row.addView(getTextView(""+r));
            board.addView(row);
        }



        // Fila inferior
        addTextViews();
    }

    private void addTextViews() {
        TableRow row;

        row = new TableRow(this);
        row.addView(getTextView(""));

        for (int i = 0; i < 8; i++)
            row.addView(getTextView(String.valueOf((char) ('A' + i))));

        row.addView(getTextView(""));

        board.addView(row);
    }

//    private View getCell(Coordinate coordinate) {
//        DisplayMetrics displayMetrics = new DisplayMetrics();
//
//        ((Activity) this).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
//
//        int widh = displayMetrics.widthPixels;
//
//        ImageView imageView = new ImageView(this);
//
//        if((coordinate.getRow() - 1 + coordinate.getColumn() - 'A') % 2 == 0)
//            imageView.setBackgroundColor(getResources().getColor(R.color.cell_white,getApplicationContext().getTheme()));
//         else
//            imageView.setBackgroundColor(getResources().getColor(R.color.cell_black,getApplicationContext().getTheme()));
//
//        imageView.setMaxWidth(widh/10);
//        imageView.setMinimumWidth(widh/10);
//        imageView.setMaxHeight(widh/10);
//        imageView.setMinimumHeight(widh/10);
//
//        return imageView;
//    }

    private TextView getTextView(String text) {

        DisplayMetrics displayMetrics = new DisplayMetrics();

        ((Activity) this).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        int widh = displayMetrics.widthPixels;

        TextView txtView = new TextView(this);

        txtView.setText(text);
        txtView.setTextColor(getResources().getColor(R.color.white, getApplicationContext().getTheme()));
        txtView.setBackgroundColor(getResources().getColor(R.color.black, getApplicationContext().getTheme()));
        txtView.setWidth(widh / 10);
        txtView.setHeight(widh / 10);
        txtView.setGravity(Gravity.CENTER);

        return txtView;
    }
}