package com.example.lab5.ui.test;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.lab5.databinding.FragmentTestBinding;

public class TestFragment extends Fragment {

    private FragmentTestBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        TestViewModel testViewModel =
                new ViewModelProvider(this).get(TestViewModel.class);

        binding = FragmentTestBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.buttonTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] answers = {"Вода", "Воздух", "Земля", "Огонь"};
                boolean[] results = {false, false, false, false};

                AlertDialog.Builder builder = new AlertDialog.Builder(root.getContext());
                builder.setTitle("Ответ")
                        .setPositiveButton("Принять", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();

                                String result = "Ошибка!";

                                if (!results[0] && !results[1] && results[2] && !results[3]) {
                                    result = "Всё верно!";
                                }

                                Toast toast = Toast.makeText(root.getContext(), result, Toast.LENGTH_SHORT);
                                toast.show();
                            }
                        })
                        .setCancelable(false)
                        .setMultiChoiceItems(answers, results, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                                results[i] = b;
                            }
                        });


                AlertDialog alert = builder.create();
                alert.show();
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