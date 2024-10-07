package com.mukudev.easy2do.Fragments;

import android.media.MediaPlayer;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.mukudev.easy2do.R;

public class Fragment2MinTaskRule extends Fragment {
    private TextView timerTextView;
    private Button startTimerButton;
    private CountDownTimer countDownTimer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_2min_task_rule, container, false);

        timerTextView = view.findViewById(R.id.timerTextView);
        startTimerButton = view.findViewById(R.id.startTimerButton);

        startTimerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTimer();
            }
        });

        return view;
    }

    private void startTimer() {
        // Reset the timer text to 2 minutes
        timerTextView.setText("02:00");

        // Create a CountDownTimer for 2 minutes (120000 milliseconds)
        countDownTimer = new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                // Update the timer text every second
                int secondsRemaining = (int) (millisUntilFinished / 1000);
                String timeFormatted = String.format("%02d:%02d", secondsRemaining / 60, secondsRemaining % 60);
                timerTextView.setText(timeFormatted);
            }

            @Override
            public void onFinish() {
                // Timer finished, play sound
                timerTextView.setText("Time's up!");
                playSound();
                startTimerButton.setText("Restart!");
            }
        }.start();
    }

    private void playSound() {
        // Load the sound from resources (make sure to have a sound file in res/raw)

        //Sound Effect by UNIVERSFIELD from Pixabay
        MediaPlayer mediaPlayer = MediaPlayer.create(getContext(), R.raw.timer_end);
        mediaPlayer.start();

        // Release the media player resources after playback
        mediaPlayer.setOnCompletionListener(mp -> {
            mp.release();
        });
    }
}