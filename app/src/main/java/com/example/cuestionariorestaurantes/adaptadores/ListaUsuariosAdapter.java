package com.example.cuestionariorestaurantes.adaptadores;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cuestionariorestaurantes.R;
import com.example.cuestionariorestaurantes.VerActivity;
import com.example.cuestionariorestaurantes.entities.Registros;

import java.util.ArrayList;

public class ListaUsuariosAdapter extends RecyclerView.Adapter<ListaUsuariosAdapter.UsuariosViewHolder> {

    ArrayList<Registros> ListaRegistros;
    public  ListaUsuariosAdapter(ArrayList<Registros> ListaRegistros){
        this.ListaRegistros = ListaRegistros;

    }
    @NonNull
    @Override
    public UsuariosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_item_usuario, null, false);
        return new UsuariosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UsuariosViewHolder holder, int position) {

        holder.viewNombre.setText(ListaRegistros.get(position).getNombre());
        holder.viewCorreo.setText(ListaRegistros.get(position).getCorreo());
        holder.viewContraseña.setText(ListaRegistros.get(position).getContraseña());
        holder.viewTelefono.setText(ListaRegistros.get(position).getTelefono());
    }

    @Override
    public int getItemCount() {
         return ListaRegistros.size();

    }

    public class UsuariosViewHolder extends RecyclerView.ViewHolder {

        TextView viewNombre, viewCorreo, viewContraseña, viewTelefono;
        public UsuariosViewHolder(@NonNull View itemView) {
            super(itemView);

            viewNombre = itemView.findViewById(R.id.viewNombre);
            viewCorreo = itemView.findViewById(R.id.viewCorreo);
            viewContraseña = itemView.findViewById(R.id.viewContraseña);
            viewTelefono = itemView.findViewById(R.id.viewTelefono);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, VerActivity.class);
                    intent.putExtra("id", ListaRegistros.get(getAdapterPosition()).getTelefono());
                    context.startActivity(intent);
                }
            });
        }
    }
}
