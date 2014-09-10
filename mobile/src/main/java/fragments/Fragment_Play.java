package fragments;

import android.app.Activity;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import com.mejorandola.sfotipy.R;

import java.util.ArrayList;
import java.util.logging.Handler;


public class Fragment_Play extends Fragment implements MediaPlayer.OnCompletionListener, SeekBar.OnSeekBarChangeListener {

    // The TAG for debugging
    private static final String TAG = "Fragment_Play";

    // The interface instance
    private OnFragmentInteractionListener onFragmentInteractionListener;

    // The ViewPage, its content and its adapter
    private ViewPager viewPager;
    private ArrayList<Fragment_Cover> songs;
    private ViewPagerAdapter viewPagerAdapter;

    // The seek layout views
    private TextView time_passed;
    private TextView time_remain;
    private SeekBar seekBar;

    // The title and the author
    private TextView title;
    private TextView author;

    // The controls views
    private ImageButton backward;
    private ImageButton play;
    private ImageButton forward;
    private ImageButton random;
    private ImageButton sound;

    // The Media Player
    private MediaPlayer mediaPlayer;

    // Handler to update UI timer, progress bar etc,.
    private Handler handler;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_play, container, false);

        // The ViewPage, its content, adapter and its page listener
        viewPager = (ViewPager) rootView.findViewById(R.id.fragment_play_viewpager);
        songs = getExampleSongs();
        viewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.setOnPageChangeListener(onPageChangeListener);

        // The seek layout views
        time_passed = (TextView) rootView.findViewById(R.id.fragment_play_time_passed);
        time_remain = (TextView) rootView.findViewById(R.id.fragment_play_time_remain);
        seekBar = (SeekBar) rootView.findViewById(R.id.fragment_play_seekbar);

        // The title and the author
        title = (TextView) rootView.findViewById(R.id.fragment_play_title);
        author = (TextView) rootView.findViewById(R.id.fragment_play_author);

        // The controls views
        backward = (ImageButton) rootView.findViewById(R.id.fragment_play_backward);
        play = (ImageButton) rootView.findViewById(R.id.fragment_play_play);
        forward = (ImageButton) rootView.findViewById(R.id.fragment_play_forward);
        random = (ImageButton) rootView.findViewById(R.id.fragment_play_random);
        sound = (ImageButton) rootView.findViewById(R.id.fragment_play_sound);

        // The Media Player
        mediaPlayer = new MediaPlayer();

        // Listeners
        seekBar.setOnSeekBarChangeListener(this); // Important
        mediaPlayer.setOnCompletionListener(this); // Important

        // Set some fonts
        Typeface font = Typeface.createFromAsset(getActivity().getAssets(),
                "VarelaRound-Regular.ttf");
        title.setTypeface(font);
        author.setTypeface(font);

        return rootView;
    }

    private ArrayList<Fragment_Cover> getExampleSongs() {

        ArrayList<Fragment_Cover> exampleSongs = new ArrayList<Fragment_Cover>();

        for (int i = 0; i < 5; i++) {
            exampleSongs.add(new Fragment_Cover());
        }

        return exampleSongs;
    }


    private ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageSelected(int arg0) {

        }
    };

    private class ViewPagerAdapter extends FragmentPagerAdapter {

        public ViewPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override
        public Fragment getItem(int position) {

            return songs.get(position);

        }

        @Override
        public int getCount() {
            return songs.size();
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            onFragmentInteractionListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        onFragmentInteractionListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        public void onFragmentPlayPlay(boolean isPlaying);

        public void onFragmentPlayBackward();

        public void onFragmentPlayForward();

        public void onFragmentPlayRandom(boolean isRandom);
    }


    // The necessary for the media player
    @Override
    public void onCompletion(MediaPlayer mp) {

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
