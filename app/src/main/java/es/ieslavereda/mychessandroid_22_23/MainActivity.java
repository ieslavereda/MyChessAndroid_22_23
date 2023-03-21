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

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TableLayout board;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TableRow row;

        board = findViewById(R.id.board);
        textView = findViewById(R.id.textView);







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



    @Override
    public void onClick(View view) {
        if (view instanceof Cell)
            textView.setText(((Cell) view).getCoordinate().toString());
        else
            textView.setText(((TextView) view).getText());
    }
}