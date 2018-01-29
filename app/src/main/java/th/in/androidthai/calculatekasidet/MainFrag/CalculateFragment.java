package th.in.androidthai.calculatekasidet.MainFrag;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import th.in.androidthai.calculatekasidet.MainActivity;
import th.in.androidthai.calculatekasidet.R;

public class CalculateFragment extends Fragment implements View.OnClickListener {


//    Explicit

    private TextView textView;
    private Button buttonC, button1, button2, button3, buttonDevide,
                            button4, button5, button6, buttonMultiply,
                            button7, button8, button9, buttonMinus,
                            button0, buttonEqual, buttonPlus;

    private String displayString = "";
    private double num1ADouble = 0, displayADouble;
    private String tag = "23JanV1";
    private boolean AddABoolean = false, ainusABoolean = false;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//       create toolbar

        createToolbar();

//        Initial View

        initialView();

//        one controller

        oneController();

//        two controller

        twoController();

//        three controller

        threeController();

//        four controller

        fourController();

//        number controller

        numberController();
    }

    private void numberController() {
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        buttonDevide.setOnClickListener(this);
        buttonMultiply.setOnClickListener(this);
        buttonMinus.setOnClickListener(this);
        buttonPlus.setOnClickListener(this);
        buttonEqual.setOnClickListener(this);
        buttonC.setOnClickListener(this);
    }

    private void fourController() {
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               showDisplay("4");
            }
        });
    }

    private void threeController() {
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDisplay("3");
            }
        });
    }

    private void twoController() {
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDisplay("2");
            }
        });
    }

    private void oneController() {
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Show Display

                showDisplay("1");
            }
        });
    }

    private void showDisplay(String strdisplay) {
        StringBuilder stringBuilder = new StringBuilder();
        displayString = displayString + stringBuilder.append(strdisplay).toString();
        textView.setText(displayString);
    }

    private void initialView() {
        textView = getView().findViewById(R.id.txtDisplay);
        buttonC = getView().findViewById(R.id.btnC);
        button0 = getView().findViewById(R.id.btn0);
        button1 = getView().findViewById(R.id.btn1);
        button2 = getView().findViewById(R.id.btn2);
        button3 = getView().findViewById(R.id.btn3);
        button4 = getView().findViewById(R.id.btn4);
        button5 = getView().findViewById(R.id.btn5);
        button6 = getView().findViewById(R.id.btn6);
        button7 = getView().findViewById(R.id.btn7);
        button8 = getView().findViewById(R.id.btn8);
        button9 = getView().findViewById(R.id.btn9);
        buttonDevide = getView().findViewById(R.id.btnDevice);
        buttonMultiply = getView().findViewById(R.id.btnMultiply);
        buttonMinus = getView().findViewById(R.id.btnMinus);
        buttonPlus = getView().findViewById(R.id.btnPlus);
        buttonEqual = getView().findViewById(R.id.btnEqual);





    }

    private void createToolbar() {
        Toolbar toolbar = getView().findViewById(R.id.toolbarMain);
        ((MainActivity) getActivity()).setSupportActionBar(toolbar);

        ((MainActivity) getActivity()).getSupportActionBar()
                .setTitle("Calculate");


        ((MainActivity) getActivity()).getSupportActionBar()
                .setHomeButtonEnabled(true);
        ((MainActivity) getActivity()).getSupportActionBar()
                .setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ((MainActivity) getActivity()).getSupportFragmentManager().popBackStack();

            }
        });
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calculate, container, false);
        return  view;

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.btn5:
                showDisplay("5");
                break;

            case R.id.btn6:
                showDisplay("6");
                break;

            case R.id.btn7:
                showDisplay("7");
                break;

            case R.id.btn8:
                showDisplay("8");
                break;

            case R.id.btn9:
                showDisplay("9");
                break;

            case R.id.btn0:
                showDisplay("0");
                break;

            case R.id.btnC:
//                 Clear Display
                clearDisplay();
                 break;

            case R.id.btnPlus:

                AddABoolean = true;

                displayADouble = Double.parseDouble(displayString);

                if (num1ADouble == 0) {
                    num1ADouble = displayADouble;

                } else {

                    if (ainusABoolean) {
                        num1ADouble = num1ADouble - displayADouble;
                        ainusABoolean = false;

                    } else {
                        num1ADouble = num1ADouble + displayADouble;

                    }

                }

                Log.d(tag, "num1 === " + num1ADouble);

                clearDisplay();

                break;

            case R.id.btnEqual:

                displayADouble = Double.parseDouble(displayString);


                Log.d(tag, "num1ADouble ==" + num1ADouble);
                Log.d(tag, "displayADouble ==" + displayADouble);
                Log.d(tag, "AddBoolean ==" + AddABoolean);

                if (AddABoolean) {
                    num1ADouble = num1ADouble + displayADouble;
                    AddABoolean = false;
                } else if (ainusABoolean) {
                    num1ADouble = num1ADouble - displayADouble;
                    ainusABoolean = false;
                }

                Log.d(tag, "num1ADouble after if ==" + num1ADouble);

                textView.setText(Double.toString(num1ADouble));
                displayString = "0";

                break;

            case R.id.btnMinus:

                ainusABoolean = true;

                if (num1ADouble == 0) {

                    num1ADouble = Double.parseDouble(displayString);

                } else {

                    if (AddABoolean) {
                        num1ADouble = num1ADouble + Double.parseDouble(displayString);
                        AddABoolean = false;

                    } else {
                        num1ADouble = num1ADouble - Double.parseDouble(displayString);

                    }

                }

                Log.d(tag,"num1 at btnMinus ==" + num1ADouble);
                clearDisplay();

                break;

        }

    }

    private void clearDisplay() {

        if (AddABoolean) {

            textView.setText("");
            displayString = "";
            displayADouble = 0;

        } else if (ainusABoolean) {

            textView.setText("");
            displayString = "";
            displayADouble = 0;

        } else {

            textView.setText("");
            displayString = "";
            displayADouble = 0;
            num1ADouble = 0;

        }



    }
}
