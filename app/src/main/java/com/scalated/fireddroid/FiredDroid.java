package com.scalated.fireddroid;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by scalated on 9/10/16.
 */
public class FiredDroid {

    public interface DataChangeListener {
        void onDataChanged(DataSnapshot data);
    }

    public interface CancelledListener {
        void onCancelled(DatabaseError error);
    }

    public static void loadData(DatabaseReference reference, final DataChangeListener d) {
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                d.onDataChanged(dataSnapshot);
            }

            @Override
            public void onCancelled(DatabaseError error) {

            }
        });
    }

    public static void loadData(Query reference, final DataChangeListener d) {
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                d.onDataChanged(dataSnapshot);
            }

            @Override
            public void onCancelled(DatabaseError error) {

            }
        });
    }

    public static void loadData(DatabaseReference reference, final DataChangeListener d, final CancelledListener c) {
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                d.onDataChanged(dataSnapshot);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                c.onCancelled(databaseError);
            }
        });
    }

    public static void addValueEventListener(DatabaseReference reference, final DataChangeListener d) {
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                d.onDataChanged(dataSnapshot);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public static void addValueEventListener(DatabaseReference firebase, final DataChangeListener d,
                                             final CancelledListener c) {
        firebase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                d.onDataChanged(dataSnapshot);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                c.onCancelled(databaseError);
            }
        });
    }
}