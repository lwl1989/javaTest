package Obj;

import Annotations.Sys;

public class Finalize {

    static boolean gcrun = false;
    static boolean f = false;
    static int created = 0;
    static int finalized = 0;

    int i;

    Finalize() {
        i = ++created;
        if(created == 47) {
            System.out.println("craeted 47");
        }
    }

    protected void finalize() {
        if(!gcrun) {
            gcrun = true;
            System.out.println("Beginning to finalize after "+ created + " Finalize");
        }
        if(i==47) {
            System.out.println("47 "+ "setting flag to stop");
            f=true;
        }
        finalized++;
        if(finalized >= created) {
            System.out.println("all finalized "+finalized);
        }
    }

    public static void main(String[] args) {
        while (!Finalize.f) {
            new Finalize();
            new String("To Take up space");
        }

        System.out.println("After all Finalized have been created");
        System.out.println("total created = "+Finalize.created);
        System.out.println("total finalized = "+Finalize.finalized);

        System.out.println("gc");
        System.gc();
        System.out.println("run finalize");
        System.runFinalization();

        System.out.println("bye");

        //System.runFinalizersOnExit(true);
    }
}


