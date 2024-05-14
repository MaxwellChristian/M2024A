package in.maxwell.m2024a.person_demo;

import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import in.maxwell.m2024a.R;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.PersonViewHolder> {

    private final ArrayList<Person> alPersonList;
    private OnPersonClickListener onPersonClickListener;

    public PersonAdapter(ArrayList<Person> alPersonList) {
        this.alPersonList = alPersonList;
    }

    @NonNull
    @Override
    public PersonAdapter.PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.person_item, parent, false);
        return new PersonViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonAdapter.PersonViewHolder holder, int position) {

        Person person = alPersonList.get(holder.getAdapterPosition());
        holder.personName.setText(String.format("%s %s", person.getFirstName(), person.getLastName()));
        if (person.getGender() == Person.Gender.MALE) {
            holder.personImage.setImageResource(android.R.drawable.ic_menu_myplaces);
        }
        if (person.getGender() == Person.Gender.FEMALE) {
            holder.personImage.setImageResource(android.R.drawable.ic_menu_my_calendar);
        }

        // set the click listener
        holder.itemView.setOnClickListener(view -> {
            if (onPersonClickListener != null) {
                onPersonClickListener.onPersonClick(holder.getAdapterPosition(), person);
            }
        });

        holder.itemView.setLongClickable(true);

        holder.itemView.setOnLongClickListener(v -> {
            Log.d("Person Adapter", "onPersonLongClick: " + person);
            return true;
        });

    }

    public interface OnPersonClickListener {
        void onPersonClick(int position, Person person);
    }

    public interface OnPersonLongClickListener {
        void onPersonLongClick(int position, Person person);
    }

    @Override
    public int getItemCount() {
        return alPersonList.size();
    }

    public void setOnPersonClickListener(OnPersonClickListener onPersonClickListener) {
        this.onPersonClickListener = onPersonClickListener;
    }

    public static class PersonViewHolder extends RecyclerView.ViewHolder {
        public TextView personName;
        ImageView personImage;

        public PersonViewHolder(@NonNull View itemView) {
            super(itemView);

            personName = itemView.findViewById(R.id.tvPersonFullName);
            personImage = itemView.findViewById(R.id.ivPerson);

        }
    }


}
