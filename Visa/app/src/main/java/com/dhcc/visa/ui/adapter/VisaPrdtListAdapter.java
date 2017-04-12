package com.dhcc.visa.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dhcc.visa.R;
import com.dhcc.visa.model.bean.VisaPrdtBean;
import com.dhcc.visa.ui.view.home.VisaDetailActivity;

import java.util.List;

/**
 * Created by ZNK on 2017/4/11.
 */

public class VisaPrdtListAdapter extends RecyclerView.Adapter<VisaPrdtListAdapter.VisaViewHoder> {


    private List<VisaPrdtBean> visaPrdtBeenList;
    private Context mContext;

    public VisaPrdtListAdapter(Context context, List visaPrdtBeenList) {
        mContext = context;
        this.visaPrdtBeenList = visaPrdtBeenList;
    }

    public class VisaViewHoder extends RecyclerView.ViewHolder {

//        @BindView(R.id.tv_prdt_name)
//        TextView tvPrdtName;
//        @BindView(R.id.tv_sign_out_rate_data)
//        TextView tvSignOutRateData;
//        @BindView(R.id.tv_original_price)
//        TextView tvOriginalPrice;
//        @BindView(R.id.tv_number_of_people_handling)
//        TextView tvNumberOfPeopleHandling;
//        @BindView(R.id.tv_number_of_people_comments)
//        TextView tvNumberOfPeopleComments;
//        @BindView(R.id.tv_current_price)
//        TextView tvCurrentPrice;
        private TextView tvPrdtName;
        private TextView tvSignOutRateData;
        private TextView tvOriginalPrice;
        private TextView tvNumberOfPeopleHandling;
        private TextView tvNumberOfPeopleComments;
        private TextView tvCurrentPrice;
        public VisaViewHoder(View view) {
            super(view);
            tvPrdtName = (TextView) view.findViewById(R.id.tv_prdt_name);
            tvSignOutRateData = (TextView) view.findViewById(R.id.tv_sign_out_rate_data);
            tvOriginalPrice = (TextView) view.findViewById(R.id.tv_original_price);
            tvNumberOfPeopleHandling = (TextView) view.findViewById(R.id.tv_number_of_people_handling);
            tvNumberOfPeopleComments = (TextView) view.findViewById(R.id.tv_number_of_people_comments);
            tvCurrentPrice = (TextView) view.findViewById(R.id.tv_current_price);

        }
    }

    @Override
    public VisaViewHoder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_visa_prdt, parent, false);
        final VisaViewHoder visaViewHoder = new VisaViewHoder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, VisaDetailActivity.class);
                mContext.startActivity(intent);
            }
        });
        return visaViewHoder;
    }

    @Override
    public void onBindViewHolder(VisaViewHoder holder, int position) {

        VisaPrdtBean visaPrdtBean = visaPrdtBeenList.get(position);
        holder.tvOriginalPrice.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG);  // 设置中划线并加清晰
    }

    @Override
    public int getItemCount() {
        return visaPrdtBeenList == null ? 0 : visaPrdtBeenList.size();
    }
}
