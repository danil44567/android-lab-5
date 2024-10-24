package com.example.lab5.ui.notifications;

import android.app.NotificationManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.lab5.MyPushNotification;
import com.example.lab5.databinding.FragmentNotificationsBinding;

public class NotificationsFragment extends Fragment {

    private FragmentNotificationsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        NotificationsViewModel notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        binding.notifButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyPushNotification myPushNotification = new MyPushNotification(root.getContext(),
                        root.getContext().getSystemService(NotificationManager.class));
                myPushNotification.sendNotify("Т-413901", "Гладышев Данил Сергеевич");
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}