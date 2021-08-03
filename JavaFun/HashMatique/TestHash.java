import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class TestHash {
    public static void main(String[] args) {
        HashMap<String, String> trackList = new HashMap<String, String>();
        // create 5 song pairs (title, lyric)
        trackList.put("Cardigan", "Vintage tee, brand new phone High heels on cobblestones When you are young, they assume you know nothing");
        trackList.put("Exile", "I can see you standin', honey/ With his arms around your body/ Laughin' but the joke's not funny at all/ And it took you five whole minutes");
        trackList.put("Lover", "We could leave the Christmas lights up 'til January/ And this is our place, we make the rules");
        trackList.put("Look What You Made Me Do", "I don't like your little games/ Don't like your tilted stage/ The role you made me play of the fool/ No, I don't like you");
        trackList.put("August", "Salt air, and the rust on your door/ I never needed anything more");


        // pull out one song by its track title
        System.out.println(trackList.get("Lover"));

        // print out all the track names and lyrics in the format Track: Lyrics
        Set<String> titles = trackList.keySet();
        for (String title : titles){
            System.out.println("\n");
            System.out.println(String.format(("%s: %s"), title, trackList.get(title)));
        }
    }
}
