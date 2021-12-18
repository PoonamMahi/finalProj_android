package com.example.final_project;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

    class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {

        // creating variables for context and arrayList
        private Context context;
        private ArrayList<ContactsModal> contactsModalArrayList;

        // creating a constructor
        public ContactAdapter(Context context, ArrayList<ContactsModal> contactsModalArrayList) {
            this.context = context;
            this.contactsModalArrayList = contactsModalArrayList;
        }

        @NonNull
        @Override
        public ContactAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new ContactAdapter.ViewHolder(LayoutInflater.from(context).inflate(R.layout.contacts_items, parent, false));

        }

        public void filterList(ArrayList<ContactsModal> filterllist) {
            contactsModalArrayList = filterllist;
            notifyDataSetChanged();
        }

        @Override
        public void onBindViewHolder(@NonNull ContactAdapter.ViewHolder holder, int position) {
            ContactsModal modal = contactsModalArrayList.get(position);
            holder.contactTV.setText(modal.getUserName());

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(context, contact_details.class);
                    i.putExtra("name", modal.getUserName());
                    i.putExtra("contact", modal.getContactNumber());
                    context.startActivity(i);
                }
            });
        }

        @Override
        public int getItemCount() {
            return contactsModalArrayList.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            private ImageView contactIV;
            private TextView contactTV;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                contactIV = itemView.findViewById(R.id.ivContact);
                contactTV = itemView.findViewById(R.id.tvContactName);
            }
        }
    }
