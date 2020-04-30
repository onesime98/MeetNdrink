package fr.point.meetndrink;

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

    @Override
    protected void onBindViewHolder(@NonNull ReservationHolder holder, int position, @NonNull Reservation model) {
        holder.textViewName.setText(model.getName());
        holder.textViewClient.setText(model.getClient());
        holder.textViewDate.setText(model.getDate());
        holder.textViewHeure.setText(model.getHeure());
        holder.textViewNbpers.setText(model.getNbpers());



    }

    @NonNull
    @Override
    public ReservationHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v  = LayoutInflater.from(parent.getContext()).inflate(R.layout.reservation_item,parent,false);
        return new ReservationHolder(v);
    }

    class ReservationHolder extends RecyclerView.ViewHolder{
        TextView textViewName;
        TextView textViewClient;
        TextView textViewDate;
        TextView textViewHeure;
        TextView textViewNbpers;


        public ReservationHolder(@NonNull View itemView) {
            super(itemView);

            textViewName = itemView.findViewById(R.id.textview_name);
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
