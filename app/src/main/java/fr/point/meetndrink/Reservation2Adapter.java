package fr.point.meetndrink;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class Reservation2Adapter extends FirestoreRecyclerAdapter<Reservation2, Reservation2Adapter.Reservation2Holder> {

    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public Reservation2Adapter(@NonNull FirestoreRecyclerOptions<Reservation2> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull Reservation2Holder holder, int position, @NonNull Reservation2 model) {
        holder.textViewNombar.setText(model.getNombar());
        holder.textViewHeure.setText(model.getHeure());
        holder.textViewDate.setText(model.getDate());
    }

    @NonNull
    @Override
    public Reservation2Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.reservation_item,
                parent);
        return new Reservation2Holder(v);
    }

    class Reservation2Holder extends RecyclerView.ViewHolder {
        TextView textViewNombar;
        TextView textViewHeure;
        TextView textViewDate;

        public Reservation2Holder( View itemView) {
            super(itemView);
            textViewNombar = itemView.findViewById(R.id.text_view_nombar);
            textViewDate = itemView.findViewById(R.id.text_view_date);
            textViewHeure = itemView.findViewById(R.id.text_view_heure);
        }
    }
}
