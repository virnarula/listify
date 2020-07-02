import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.virnarula.listify.AssignmentModel;
import com.virnarula.listify.R;
import com.virnarula.listify.model.Assignment;

import java.util.ArrayList;
import java.util.List;

public class AssignmentAdapter extends RecyclerView.Adapter<AssignmentAdapter.AssignmentViewHolder> {

    private Context mContext;
    private List<AssignmentModel> adapter;

    public AssignmentAdapter(Context context, List<AssignmentModel> assignmentModelList) {
        mContext = context;
        adapter = assignmentModelList;
    }

    public class AssignmentViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public ArrayList<CheckBox> taskChecks;
        public TextView complete;
        public LinearLayout cardLinear;
        public LinearLayout taskLinear;

        public AssignmentViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title_text_view);
            taskChecks = new ArrayList<CheckBox>();
            taskChecks.add((CheckBox) itemView.findViewById(R.id.checkBox));
            complete = itemView.findViewById(R.id.finish_btn);
            cardLinear = itemView.findViewById(R.id.fullLinear);
            taskLinear = itemView.findViewById(R.id.tasksLinear);
        }
    }

    @NonNull
    @Override
    public AssignmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.assignment_view, parent, false);
        return new AssignmentViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AssignmentViewHolder holder, int position) {
        AssignmentModel model = adapter.get(position);
        holder.title.setText(model.getTitle());
        if(model.getTasks().isEmpty()) {
//            holder.taskChecks.
        } else {

        }
    }

    @Override
    public int getItemCount() {
        return adapter.size();
    }
}
