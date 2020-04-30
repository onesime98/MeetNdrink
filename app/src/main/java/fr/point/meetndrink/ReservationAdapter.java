package fr.point.meetndrink;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.DocumentSnapshot;

public class ReservationAdapter extends FirestoreRecyclerAdapter<Reservation, ReservationAdapter.ReservationHolder> {
    private OnItemClickListener listener;
    public ReservationAdapter(@NonNull FirestoreRecyclerOptions<Reservation> options) {
        super(options);
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onBindViewHolder(@NonNull ReservationHolder holder, int position, @NonNull Reservation model) {
        holder.textViewNombar.setText("Nom du bar : "+model.getNombar());
        holder.textViewClient.setText("Nom et prénom : "+model.getClient());
        holder.textViewDate.setText("Date : "+model.getDate());
        holder.textViewHeure.setText("Heure : "+model.getHeure());
        holder.textViewNbpers.setText("Nombre de personnes : "+model.getNbpers());



    }

    @NonNull
    @Override
    public ReservationHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v  = LayoutInflater.from(parent.getContext()).inflate(R.layout.reservation_item,parent,false);
        return new ReservationHolder(v);
    }

    class ReservationHolder extends RecyclerView.ViewHolder{
        TextView textViewNombar;
        TextView textViewClient;
        TextView textViewDate;
        TextView textViewHeure;
        TextView textViewNbpers;


        public ReservationHolder(@NonNull View itemView) {
            super(itemView);

            textViewNombar = itemView.findViewById(R.id.textview_nombar);
            textViewClient = itemView.findViewById(R.id.textview_client);
            textViewDate = itemView.findViewById(R.id.textview_date);
            textViewHeure = itemView.findViewById(R.id.textview_heure);
            textViewNbpers = itemView.findViewById(R.id.textview_nbpers);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if(position!= RecyclerView.NO_POSITION && listener !=null){
                        listener.onItemClick(getSnapshots().getSnapshot(position),position);
                    }
                }
            });

        }
    }

    public interface OnItemClickListener {
        void onItemClick(DocumentSnapshot documentSnapshot, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}
