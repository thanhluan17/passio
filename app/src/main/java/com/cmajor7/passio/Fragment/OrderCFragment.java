package com.cmajor7.passio.Fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.cmajor7.passio.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OrderCFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OrderCFragment extends Fragment {
    GridView gridView;
    String mName[] = {"Ice Americano", "Ice Cappucino", "Ice Espresso", "Ice Mocha", "Bạc Xĩu", "White Coffee"};
    String mPrice[] = {"44.000đ", "36.000đ", "39.000đ", "33.000", "41.000đ", "46.000đ"};
    int images[] = {R.drawable.american, R.drawable.capu, R.drawable.espresso, R.drawable.mocha, R.drawable.bacxiu, R.drawable.white};
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public OrderCFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment OrderCFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static OrderCFragment newInstance(String param1, String param2) {
        OrderCFragment fragment = new OrderCFragment();
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

    class MyAdapter extends ArrayAdapter<String> {
        Context context;
        String rName[];
        String rPrice[];
        int rImgs[];

        MyAdapter(Context c, String name[], String price[], int imgs[]) {
            super(c, R.layout.item_order, R.id.name, name);
            this.context = c;
            this.rName = name;
            this.rPrice = price;
            this.rImgs = imgs;
        }

        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.item_order, parent, false);
            ImageView images = row.findViewById(R.id.image);
            TextView myName = row.findViewById(R.id.name);
            TextView myPrice = row.findViewById(R.id.price);

            images.setImageResource(rImgs[position]);
            myName.setText(rName[position]);
            myPrice.setText(rPrice[position]);

            return row;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_order_c, container, false);
        gridView = root.findViewById(R.id.gv_passio);
        OrderCFragment.MyAdapter adapter = new OrderCFragment.MyAdapter(getActivity(), mName, mPrice, images);
        gridView.setAdapter(adapter);

        return root;
    }
}