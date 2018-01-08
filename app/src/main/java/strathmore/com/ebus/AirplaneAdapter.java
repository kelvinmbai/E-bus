package strathmore.com.ebus;

/**
 * Created by mambo on 21/10/2017.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class AirplaneAdapter extends SelectableAdapter<AirplaneAdapter.ViewHolder> {

    private ArrayList<Seat> seats;
    private Context context;


    AirplaneAdapter(Context context, ArrayList<Seat> seats) {
        this.seats = seats;
        this.context = context;

    }

    @Override
    public int getItemCount() {
        return seats.size();
    }

    @Override
    public AirplaneAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item_seat, parent, false));
    }

    @Override
    public void onBindViewHolder(final AirplaneAdapter.ViewHolder holder, int position) {

        final Seat seat = seats.get(position);
        // 0 = free
        //1 = taken

        if(seat.getState() == 0) {
            holder.seat.setImageResource(R.drawable.seat_normal);
        }else {
            holder.seat.setImageResource(R.drawable.seat_normal_selected);
        }

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                seat.setState(1 - seat.getState());
                holder.seat.setImageResource(seat.getState() == 0 ? R.drawable.seat_normal :
                        R.drawable.seat_normal_selected);
            }
        });

    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView seat;
        public View view;

        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            seat = itemView.findViewById(R.id.img_seat);
        }

    }

    //
//    if (viewType == AbstractItem.TYPE_CENTER) {
//        View itemView = mLayoutInflater.inflate(R.layout.list_item_seat, parent, false);
//        return new CenterViewHolder(itemView);
//    } else if (viewType == AbstractItem.TYPE_EDGE) {
//        View itemView = mLayoutInflater.inflate(R.layout.list_item_seat, parent, false);
//        return new EdgeViewHolder(itemView);
//    } else {
//        View itemView = new View(mContext);
//        return new EmptyViewHolder(itemView);
//    }



}