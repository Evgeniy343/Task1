package filework;

public interface ReaderWork {
    static ReaderWork newInstance(){
        return new ReaderFileWork();
    }
}
