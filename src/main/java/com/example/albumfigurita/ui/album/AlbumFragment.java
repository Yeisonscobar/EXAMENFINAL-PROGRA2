package com.example.albumfigurita.ui.album;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.albumfigurita.databinding.FragmentAlbumBinding;
import com.example.albumfigurita.dto.UsuarioDTO;

public class AlbumFragment extends Fragment {

    private AlbumViewModel homeViewModel;
    private FragmentAlbumBinding binding;

    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentAlbumBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        cargarInformacion();
        return root;
    }


    private void cargarInformacion() {
        // To retrieve object in second Activity
        UsuarioDTO usuarioDTO = (UsuarioDTO) getActivity().getIntent().getSerializableExtra("USUARIO");

        if (usuarioDTO == null){
            Toast.makeText(getContext(), "El envio de la información falló.", Toast.LENGTH_SHORT).show();
        } else{
            final TextView textView = binding.textAlbum;

            textView.setText(usuarioDTO.toString());
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}