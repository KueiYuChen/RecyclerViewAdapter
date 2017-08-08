class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public ImageView imageView;
        public ViewHolder(View v) {
            super(v);
            textView = (TextView) v.findViewById(R.id.textView);
            imageView=(ImageView)v.findViewById(R.id.imageView);
        }
    }

    ArrayList<HashMap<String,Object>> arrayList;
    MyAdapter(){
        arrayList=new ArrayList<>();
    }
    void add(String string,int resId){
        HashMap<String,Object> HM=new HashMap<String, Object>();
        HM.put("name",string);
        HM.put("id",resId);
        arrayList.add(HM);
    }
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View cardView=LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview,parent,false);
        return new ViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final String name=arrayList.get(position).get("name").toString();
        int id=Integer.parseInt(arrayList.get((position)).get("id").toString());
        holder.textView.setText(name);
        holder.imageView.setImageResource(id);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(holder.itemView.getContext(),name,Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

}
