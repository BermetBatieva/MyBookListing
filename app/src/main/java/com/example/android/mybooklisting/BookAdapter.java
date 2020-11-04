package com.example.android.mybooklisting;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.LinearLayout;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.annotation.SuppressLint;
import com.squareup.picasso.Picasso;
import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {
    public ArrayList<Book> mBooks;
    private static OnItemClickListener mListener;

    public BookAdapter(OnItemClickListener listener) {
        mListener = listener;
        mBooks = new ArrayList<>();
    }

    public interface OnItemClickListener {
        void onItemClick(Book book);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;
        public TextView title, author, pages, date, rating;
        public LinearLayout container;
        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.cover);
            title = (TextView) itemView.findViewById(R.id.title);
            author = (TextView) itemView.findViewById(R.id.author);
            pages = (TextView) itemView.findViewById(R.id.pages);
            date = (TextView) itemView.findViewById(R.id.date);
            rating = (TextView) itemView.findViewById(R.id.rating);
            container = (LinearLayout) itemView.findViewById(R.id.container);
        }

        public void bind(final Book book, final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(book);
                }
            });
        }
    }

    public void setData(ArrayList<Book> books) {
        mBooks.addAll(books);
        notifyDataSetChanged();
    }

    @Override
    public BookAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View bookView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        final ViewHolder viewHolder = new ViewHolder(bookView);

        return viewHolder;
    }
    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(final BookAdapter.ViewHolder holder, int position) {

        final Book currentBook = mBooks.get(position);


        String link = currentBook.volumeInfo.imageLinks.thumbnail;
        link = link.replace("http", "https");
        Picasso.with(holder.imageView.getContext()).load(link).placeholder(R.drawable.book).into(holder.imageView);

        holder.title.setText(currentBook.volumeInfo.title);
        List<String> authorsArray = currentBook.volumeInfo.authors;
        StringBuilder authors = new StringBuilder();
        if (authorsArray.size() > 1) {
            for (int j = 0; j < authorsArray.size(); j++) {
                String obj = authorsArray.get(j);
                if (j != authorsArray.size() - 1) {
                    authors.append(obj).append(", ");
                }
                authors.append(obj).append(" ");
            }
        } else if (authorsArray.size() == 1) {
            String obj = authorsArray.get(0);
            authors.append(obj);
        } else {
            authors.append("N/A");
        }
        holder.author.setText(authors);

        String page = " pages";
        String pages = currentBook.volumeInfo.pageCount;
        if (pages != null) {
            holder.pages.setText(pages + page);
        } else {
            holder.pages.setText("N/A");

        }

        String date = currentBook.volumeInfo.publishedDate;
        if (!date.isEmpty()) {
            holder.date.setText(date);
        } else {
            holder.date.setText("N/A");
        }

        String rate = currentBook.volumeInfo.averageRating;
        if (rate != null) {
            holder.rating.setText(rate);
        } else {
            holder.rating.setText("0.0");
        }

        holder.bind(mBooks.get(position), mListener);
    }

    @Override
    public int getItemCount() {
        return mBooks.size();
    }

}

