package com.checkgiathucpham.jayson.fooddish;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.checkgiathucpham.jayson.FoodInfoActivity;
import com.checkgiathucpham.jayson.R;
import com.checkgiathucpham.jayson.adapter.FoodDishAdapter;
import com.checkgiathucpham.jayson.model.FoodDish;

import java.util.ArrayList;
import java.util.List;

public class FoodDish3Activity extends AppCompatActivity {

    private final String[] dishNames = {
            "Cá đuối nấu canh chua bắp chuối\n" +
                    "đậm đà, dịu ngọt",
            "Cá kho gừng sả 2",
            "Cá kho gừng sả 3",
            "Cá kho gừng sả 4",
            "Cá kho gừng sả 5"
    };
    private final int[] dishImages = {
            R.drawable.food_dish1,
            R.drawable.food_dish2,
            R.drawable.food_dish3,
            R.drawable.food_dish4,
            R.drawable.food_dish5
    };
    private final String[] dishCription = {
            "Cách nấu canh chua cá đuối là sự kết hợp giữa nước dùng chua ngọt đậm đà cùng thịt cá ngọt mềm " +
                    "cực hấp dẫn. Không những thế, cá đuối còn có lớp sụn ăn giòn giòn lạ miệng lại chứa " +
                    "nhiều chất tốt cho sức khỏe nên rất được ưa chuộng. Tuy nhiên, nếu sơ chế không đúng " +
                    "cách cá đuối sẽ rất dễ bị tanh khai giảm mất vị ngon. Vậy thì Cachnau.vn sẽ bật mí cho bạn " +
                    "mẹo nấu canh chua cá đuối không tanh với 4 biến tấu đơn giản dưới đây nhé!" + " \n " + "Nguyên Liệu:\n" +
                    "Cá đuối tươi: 300g\n" +
                    "Bắp chuối: 500g\n" +
                    "Me vắt: 80g\n" +
                    "Chanh: 2 quả\n" +
                    "Tỏi băm: 1 thìa canh\n" +
                    "Ớt sừng: 1 quả\n" +
                    "Rau thơm, ngò gai\n" +
                    "Giấm và các gia vị thông dụng" + "\n" + "Sơ chế các nguyên liệu \n" +
                    "Cá đuối làm sạch, để ráo và cắt khúc vừa ăn.\n" +
                    "Bắp chuối tước bỏ phần bẹ già bên ngoài, chỉ lấy phần non bên trong. Bào sợ hoặc thái mỏng rồi ngâm nước nước chanh pha loãng. Vớt ra rửa lại nước và để ráo.\n" +
                    "Ngò gai, rau thơm nhặt rửa sạch và thái nhỏ.\n" +
                    "Me cho vào chén nước ấm, dằm nhuyễn và lọc lấy nước cốt.",
            "test2",
            "test3",
            "test4",
            "test5"
    };
    private ListView listView;
    private FoodDishAdapter adapter;
    private EditText searchBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_dish);

        listView = findViewById(R.id.list_view_dish);
        searchBar = findViewById(R.id.search_bar);

        List<FoodDish> dishList = new ArrayList<>();
        for (int i = 0; i < dishNames.length; i++) {
            dishList.add(new FoodDish(dishNames[i], dishImages[i], dishCription[i]));
        }

        adapter = new FoodDishAdapter(this, dishList);
        listView.setAdapter(adapter);

        searchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                adapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        listView.setOnItemClickListener((parent, view, position, id) -> {
            FoodDish selectedDish = dishList.get(position);

            Intent intent = new Intent(FoodDish3Activity.this, FoodInfoActivity.class);
            intent.putExtra("food_dish", selectedDish);
            startActivity(intent);
        });

    }
}
