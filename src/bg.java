
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

public class bg {

    private static Map e = new HashMap();
    private static Map f = new HashMap();
    public ff a;
    public int b;
    public int c;
    public int d;

    private static void a(Class paramClass, String paramString) {
        if (f.containsKey(paramString)) {
            throw new IllegalArgumentException("Duplicate id: " + paramString);
        }
        e.put(paramString, paramClass);
        f.put(paramClass, paramString);
    }

    public void a(ad paramad) {
        this.b = paramad.d("x");
        this.c = paramad.d("y");
        this.d = paramad.d("z");
    }

    public void b(ad paramad) {
        String str = (String) f.get(getClass());
        if (str == null) {
            throw new RuntimeException(getClass() + " is missing a mapping! This is a bug!");
        }
        paramad.a("id", str);
        paramad.a("x", this.b);
        paramad.a("y", this.c);
        paramad.a("z", this.d);
    }

    public void e() {
    }

    public static bg c(ad paramad) {
        bg localbg = null;
        try {
            Class localClass = (Class) e.get(paramad.h("id"));
            if (localClass != null) {
                localbg = (bg) localClass.newInstance();
            }
        } catch (Exception localException) {
            localException.printStackTrace();
        }
        if (localbg != null) {
            localbg.a(paramad);
        } else {
            System.out.println("Skipping TileEntity with id " + paramad.h("id"));
        }
        return localbg;
    }

    public void d() {
        // hMod: Allow visibility of 'complex blocks'??
        // Hacky... but it works at least.
        for (Player player : etc.getServer().getPlayerList()) {
            bg localbg = this;
            ComplexBlock block = null;
            if (localbg instanceof ja) {
                block = new Chest((ja) localbg);
            } else if (localbg instanceof ek) {
                block = new Furnace((ek) localbg);
            } else if (localbg instanceof ko) {
                block = new Sign((ko) localbg);
            } else if (localbg instanceof cq) {
                block = new MobSpawner((cq) localbg);
            }
            if (block != null) {
                if (!(Boolean) etc.getLoader().callHook(PluginLoader.Hook.COMPLEX_BLOCK_SEND, player, block) && player.canBuild()) {
                    player.getUser().a.b.a(new gm(this.b, this.c, this.d, this));
                } else {
                    bg toSend = null;
                    if (localbg instanceof ja) {
                        toSend = new ja();
                    } else if (localbg instanceof ek) {
                        toSend = new ek();
                    } else if (localbg instanceof ko) {
                        toSend = new ko();
                    } else if (localbg instanceof cq) {
                        toSend = new cq();
                    }
                    toSend.b = b;
                    toSend.c = c;
                    toSend.d = d;
                    player.getUser().a.b.a(new gm(this.b, this.c, this.d, toSend));
                }
            } else {
                player.getUser().a.b.a(new gm(this.b, this.c, this.d, this));
            }
        }
    }

    public ju f() {
        return null;
    }

    static {
        a(ek.class, "Furnace");
        a(ja.class, "Chest");
        a(ko.class, "Sign");
        a(cq.class, "MobSpawner");
    }
}
