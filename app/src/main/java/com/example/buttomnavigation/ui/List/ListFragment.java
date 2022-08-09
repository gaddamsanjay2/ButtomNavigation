package com.example.buttomnavigation.ui.List;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.buttomnavigation.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListFragment extends Fragment {

    ListView list;
    ListReadHelper listReadHelper;
    SQLiteDatabase sqLiteDatabase1;


    ArrayList<String> arrayList=new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListFragment newInstance(String param1, String param2) {
        ListFragment fragment = new ListFragment();
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

        View root=inflater.inflate(R.layout.fragment_list,container,false);
        list=root.findViewById(R.id.listview);
        listReadHelper=new ListReadHelper(getContext());
        sqLiteDatabase1=listReadHelper.getReadableDatabase();
        Toast.makeText(getContext(), "List Selected", Toast.LENGTH_SHORT).show();

        arrayAdapter=new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1,arrayList);
        list.setAdapter(arrayAdapter);

        readData();
        // Inflate the layout for this fragment
        return root;
    }

    private void readData() {

        arrayList.clear();
        String[] col={"Id","Name","Mail"};
        Cursor cursor=sqLiteDatabase1.query("ODSEmployee",col,null,null,null,null,null);

        if (cursor.getCount()>0 && cursor!=null){
            while (cursor.moveToNext()){
                String name= cursor.getString(1);
                String mail= cursor.getString(2);

                arrayList.add("Name:" + name + "\nMail:" + mail);
                arrayAdapter.notifyDataSetChanged();
            }
        }else
        {
            Toast.makeText(getContext(), "No Record Found", Toast.LENGTH_SHORT).show();
        }
    }
}