package fr.point.meetndrink;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class BarAdapter extends FirestoreRecyclerAdapter<Bar, BarAdapter.BarHolder> {

    public BarAdapter(@NonNull FirestoreRecyclerOptions<Bar> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull BarHolder holder, int position, @NonNull Bar model) {
        holder.textViewName.setText(model.getName());
        holder.textViewDescription.setText(model.getDescription());
        holder.textViewAdresse.setText(model.getAdresse());
        holder.textViewNumtel.setText(model.getNumtel());
        holder.textViewHoraire.setText(model.getHoraire());
        holder.textViewClassification.setText(model.getClassification());


    }

    @NonNull
    @Override
    public BarHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v  = LayoutInflater.from(parent.getContext()).inflate(R.layout.bar_item,parent,false);
        return new BarHolder(v);
    }

    class BarHolder extends RecyclerView.ViewHolder{
        TextView textViewName;
        TextView textViewDescription;
        TextView textViewAdresse;
        TextView textViewNumtel;
        TextView textViewHoraire;
        TextView textViewClassification;

        public BarHolder(@NonNull View itemView) {
            super(itemView);

            textViewName = itemView.findViewById(R.id.textview_name);
            textViewDescription = itemView.findViewById(R.id.textview_description);
            textViewAdresse = itemView.findViewById(R.id.textview_adresse);
            textViewNumtel = itemView.findViewById(R.id.textview_numtel);
            textViewHoraire = itemView.findViewById(R.id.textview_horaire);
            textViewClassification = itemView.findViewById(R.id.textview_classification);

        }
    }
}
