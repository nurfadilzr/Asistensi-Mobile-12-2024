package com.example.fragment.fragment;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fragment.Post;
import com.example.fragment.R;

public class PostFragment extends Fragment {

    private Uri selectedImageUri;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_post, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EditText et_konten = view.findViewById(R.id.et_konten);
        ImageView iv_addPhoto = view.findViewById(R.id.iv_add_photo);
        Button btn_posting = view.findViewById(R.id.btn_posting);

        ActivityResultLauncher<Intent> launcherIntentGallery = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), result -> {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        if (data != null) {
                            selectedImageUri = data.getData();
                            if (selectedImageUri != null) {
                                iv_addPhoto.setImageURI(selectedImageUri);
                            }
                        }
                    }
                }
        );

        iv_addPhoto.setOnClickListener(v -> {
            Intent openGallery = new Intent(Intent.ACTION_PICK);
            openGallery.setType("image/*");
            launcherIntentGallery.launch(openGallery);
        });

        btn_posting.setOnClickListener(v -> {
            String capt = et_konten.getText().toString();

            if (selectedImageUri != null) {
                Post post = new Post(R.drawable.zuppa, "zuppa_soup", "Zuppa Soup", capt, selectedImageUri);

                Bundle bundle = new Bundle();
                bundle.putParcelable(HomeFragment.EXTRA_POST, post);

                HomeFragment homeFragment = new HomeFragment();
                homeFragment.setArguments(bundle);

                FragmentManager fragmentManager = getParentFragmentManager();
                fragmentManager.
                        beginTransaction().
                        replace(R.id.frame_container, homeFragment).
                        addToBackStack(null).
                        commit();
            } else {
                Toast.makeText(getActivity(), "Select an image first", Toast.LENGTH_SHORT).show();
            }
        });
    }
}