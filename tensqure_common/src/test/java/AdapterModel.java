public class AdapterModel {
    public static void main(String[] args) {
        Myplayer myplayer = new Myplayer();
        myplayer.play("mp3","audio.mp3");
        myplayer.play("avi","audio.mp4");
    }
}
interface Audio{
    void play(String fileName);
}
interface Video{
    void play(String fileName);
}
interface Player{
    void play(String type,String fileName);
}
class MyAudioPlayer implements Audio{
    @Override
    public void play(String fileName) {
        System.out.println("play audio file:"+fileName);
    }
}
class MyVideoPlayer implements Video{
    @Override
    public void play(String fileName) {
        System.out.println("play video file:"+fileName);
    }
}

class Myplayer implements Player{
    Audio playAdio =new MyAudioPlayer();
    Video playVideo = new MyVideoPlayer();
    @Override
    public void play(String type, String fileName) {
        if (type==null)System.out.println("没有文件格式，不能播放");
        else if (type.equalsIgnoreCase("mp3"))playAdio.play(fileName);
        else if (type.equalsIgnoreCase("avi"))playVideo.play(fileName);
    }
}