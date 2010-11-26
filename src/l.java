
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class l extends ir {

    public int a;
    public int b;
    public int c;
    public int d;
    public byte e;
    public byte f;
    public byte g;
    public int h;
    public int i;
    public int damage;

    public l() {
    }

    public l(gj paramgj) {
        this.a = paramgj.g;
        this.h = paramgj.a.c;
        this.i = paramgj.a.a;
        this.b = hf.b(paramgj.p * 32.0D);
        this.c = hf.b(paramgj.q * 32.0D);
        this.d = hf.b(paramgj.r * 32.0D);
        this.e = (byte) (int) (paramgj.s * 128.0D);
        this.f = (byte) (int) (paramgj.t * 128.0D);
        this.g = (byte) (int) (paramgj.u * 128.0D);
        this.damage = paramgj.f;
    }

    public void a(DataInputStream paramDataInputStream) {
        try {
            this.a = paramDataInputStream.readInt();
            this.h = paramDataInputStream.readShort();
            this.i = paramDataInputStream.readByte();
            this.b = paramDataInputStream.readInt();
            this.c = paramDataInputStream.readInt();
            this.d = paramDataInputStream.readInt();
            this.e = paramDataInputStream.readByte();
            this.f = paramDataInputStream.readByte();
            this.g = paramDataInputStream.readByte();
        } catch (IOException ex) {
            Logger.getLogger(l.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void a(DataOutputStream paramDataOutputStream) {
        try {
            paramDataOutputStream.writeInt(this.a);
            paramDataOutputStream.writeShort(this.h);
            paramDataOutputStream.writeByte(this.i);
            paramDataOutputStream.writeInt(this.b);
            paramDataOutputStream.writeInt(this.c);
            paramDataOutputStream.writeInt(this.d);
            paramDataOutputStream.writeByte(this.e);
            paramDataOutputStream.writeByte(this.f);
            paramDataOutputStream.writeByte(this.g);
        } catch (IOException ex) {
            Logger.getLogger(l.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void a(fa paramfa) {
        paramfa.a(this);
    }

    public int a() {
        return 22;
    }
}
