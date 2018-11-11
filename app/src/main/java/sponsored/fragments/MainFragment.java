package sponsored.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sponsored.R;

import java.util.ArrayList;
import java.util.List;

import sponsored.adapters.SponsorRecyclerAdapter;
import sponsored.models.Sponsor;

public class MainFragment extends Fragment implements View.OnClickListener {

    private List<Sponsor> recyclerSponsor = new ArrayList<>();
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        recyclerSponsor = getSponsors();

        if (recyclerSponsor != null) {
            recyclerView = (RecyclerView) view.findViewById(R.id.listSponsors);

            View header = inflater.inflate(R.layout.layout_productivity_header, container, false);
            header.setSaveEnabled(true);
            TextView tvHelpPoject = (TextView) header.findViewById(R.id.help_project);
            tvHelpPoject.setOnClickListener(this);

            LinearLayoutManager llm = new LinearLayoutManager(getActivity().getApplicationContext());
            recyclerView.setLayoutManager(llm);
            SponsorRecyclerAdapter sponsorRecyclerAdapter = new SponsorRecyclerAdapter(header, recyclerSponsor);
            recyclerView.setAdapter(sponsorRecyclerAdapter);
        }
        return view;
    }

    private List<Sponsor> getSponsors() {
        List<Sponsor> recyclerSponsor = new ArrayList<>();

        int item = 1;
        long amountDonate = 25129;
        while (item <= 5) {
            recyclerSponsor.add(new Sponsor(item, item, "title: " + item, "description: " + item, amountDonate + item));
            item++;
        }

        return recyclerSponsor;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.help_project:
                HelpProjectFragment nextFrag = new HelpProjectFragment();
                getFragmentManager().beginTransaction()
                        .replace(R.id.container, nextFrag, "TAG_FRAGMENT_HELP_PROJECT")
                        .addToBackStack(null)
                        .commit();
                break;
        }
    }
}