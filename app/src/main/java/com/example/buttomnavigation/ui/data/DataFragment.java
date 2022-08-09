package com.example.buttomnavigation.ui.data;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.buttomnavigation.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DataFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DataFragment extends Fragment {
    TextView textView;
    EditText name,mail,id;
    Button submit;
    DataHelper dataHelper;
    SQLiteDatabase sqLiteDatabase;

    String namestr,mailstr;
    int value;

    ListView listView;
    Cursor cursor;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DataFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DataFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DataFragment newInstance(String param1, String param2) {
        DataFragment fragment = new DataFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root=inflater.inflate(R.layout.fragment_data, container, false);
        name=root.findViewById(R.id.edt_txt_1);
        mail=root.findViewById(R.id.edt_txt_2);
        id=root.findViewById(R.id.edt_txt_3);

        submit=root.findViewById(R.id.submitbtn);
        dataHelper=new DataHelper(getContext());
        sqLiteDatabase=dataHelper.getReadableDatabase();
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                namestr=name.getText().toString().trim();
                mailstr=mail.getText().toString().trim();
                value=Integer.parseInt(id.getText().toString().trim());


                if(namestr.length()==0)
                {
                    name.setError("Enter name");
                }
                else if(mailstr.length()==0)
                {
                    mail.setError("enter mail");
                }


                long set=dataHelper.insert(sqLiteDatabase,value,namestr,mailstr);

                if (set == -1)
                {
                    Toast.makeText(getContext(), "Record Already Exist", Toast.LENGTH_SHORT).show();
                }else
                {
                    Toast.makeText(getContext(), "New Record Created Successfully", Toast.LENGTH_SHORT).show();
                }



            }
        });
        return root;
    }
}