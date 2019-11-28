# Navigation Bottom & Top / Splash Screen.

Start From a New Activity Using Bottom Navigation Activity.
Add a new item in bottom_nav_menu.xml in menu folder.

<item
        android:id="@+id/navigation_chat"
        android:icon="@drawable/ic_chat_bubble_outline_black_24dp"
        android:title="Chat"
        app:showAsAction="always"
        app:labelVisibilityMode="labeled"/>
        
        
Create a new fragment using mobile_navigation.xml in navigation folder.

<fragment
        android:id="@+id/navigation_chat"
        android:name="com.example.navjgation.ui.chat.ChatFragment"
        android:label="chat"
        tools:layout="@layout/fragment_chat" />
        
        
 Add a new package for chat fragment in java folder enclosed with two files Chat Fragment & Chat View Model
 
  public class ChatFragment extends Fragment {
 
    private ChatViewModel chatViewModel;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        chatViewModel =
                ViewModelProviders.of(this).get(ChatViewModel.class);
        View root = inflater.inflate(R.layout.fragment_chat, container, false);
        final TextView textView = root.findViewById(R.id.text_chat);
        chatViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}

 For Splash Screen add aimage into drawable folder.
 Change the launch activity to splashActivity in AndroidManifest.xml file.
 Add following timer code to splashActivity Java file.
 
 
   public class SplashActivity extends AppCompatActivity {
   
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        /************** DELAY TIMER **************/

        TimerTask timer = new TimerTask() {
            @Override
            public void run() {
                Intent i = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(i);
            }
        };

        Timer splashScreen = new Timer();
        splashScreen.schedule(timer, 3000);

    }
}
