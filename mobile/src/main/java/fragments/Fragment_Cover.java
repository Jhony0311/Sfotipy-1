package fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import com.mejorandola.sfotipy.R;

import customviews.SquareImageView;

public class Fragment_Cover extends Fragment {

    // The TAG for debugging
    private static final String TAG = "Fragment_Cover";

    // The views in this fragmnet
    private SquareImageView image;
    private RelativeLayout buttons;
    private ImageButton add;
    private ImageButton heart;
    private ImageButton share;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_cover, container, false);

        // The views in this layout
        image = (SquareImageView) rootView.findViewById(R.id.fragment_cover_image);
        buttons = (RelativeLayout) rootView.findViewById(R.id.fragment_cover_buttons);
        add = (ImageButton) rootView.findViewById(R.id.fragment_cover_add);
        heart = (ImageButton) rootView.findViewById(R.id.fragment_cover_heart);
        share = (ImageButton) rootView.findViewById(R.id.fragment_cover_share);

        // Make the background have some alpha
        buttons.getBackground().setAlpha(150);

        return rootView;
    }
}
