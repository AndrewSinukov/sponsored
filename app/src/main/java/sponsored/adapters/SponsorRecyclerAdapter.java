package sponsored.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sponsored.R;

import java.util.List;

import sponsored.models.Sponsor;

public class SponsorRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int FOOTER = 1;
    private static final int ITEM = 2;
    private List<Sponsor> sponsor;
    private View mViewFooter;

    public SponsorRecyclerAdapter(View applicationContext, List<Sponsor> sponsor) {
        this.sponsor = sponsor;
        this.mViewFooter = applicationContext;
    }

    @Override
    public int getItemViewType(int position) {
        return position == sponsor.size() ? FOOTER : ITEM;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        if (viewType == FOOTER) {
            return new HeaderViewHolder(mViewFooter);
        } else {
            View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_sponsor, viewGroup, false);
            SponsorViewHolder svh = new SponsorViewHolder(v);
            return svh;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (position < sponsor.size()) {
            Sponsor mSponsor = sponsor.get(position);

            SponsorViewHolder sponsorViewHolder = (SponsorViewHolder) holder;

            sponsorViewHolder.sponsorLogo.setImageResource(R.drawable.ic_launcher);
            sponsorViewHolder.sponsorTitle.setText(mSponsor.getTitle());

            sponsorViewHolder.sponsorDescription.setText(mSponsor.getDescription());
            sponsorViewHolder.sponsorAmountDonate.setText(String.valueOf(mSponsor.getAmountDonate()));
        }
    }

    @Override
    public int getItemCount() {
        if (sponsor == null) return 1;
        return sponsor.size() + 1;
    }

    private static class HeaderViewHolder extends RecyclerView.ViewHolder {
        public HeaderViewHolder(View itemView) {
            super(itemView);
        }
    }

    public static class SponsorViewHolder extends RecyclerView.ViewHolder {
        RecyclerView rv;
        ImageView sponsorLogo;
        TextView sponsorTitle;
        TextView sponsorDescription;
        TextView sponsorAmountDonate;

        SponsorViewHolder(View itemView) {
            super(itemView);
            rv = (RecyclerView) itemView.findViewById(R.id.listSponsors);
            sponsorLogo = (ImageView) itemView.findViewById(R.id.sponsorLogo);
            sponsorTitle = (TextView) itemView.findViewById(R.id.sponsorTitle);
            sponsorDescription = (TextView) itemView.findViewById(R.id.sponsorDescription);
            sponsorAmountDonate = (TextView) itemView.findViewById(R.id.sponsorAmountDonate);
        }
    }
}