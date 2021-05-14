package rmugattarov.yndx.y2021;

import java.util.*;

public class RateLimiter {
    public static void main(String[] args) {
        Scanner s = new Scanner("2 5 5\n" +
                "1 100\n" +
                "1 100\n" +
                "2 100\n" +
                "2 200\n" +
                "2 300\n" +
                "2 400\n" +
                "2 500\n" +
                "3 500\n" +
                "5 200\n" +
                "6 100\n" +
                "7 200\n" +
                "-1");
        int userLimit = s.nextInt();
        int serviceLimit = s.nextInt();
        long duration = s.nextLong();

        LinkedList<Req> serviceReqs = new LinkedList<>();
        Map<Long, Long> userReqs = new HashMap<>();

        Req nextReq = nextReq(s);
        while (nextReq != null) {
            removeExpired(serviceReqs, userReqs, nextReq, duration);
            if (userReqs.get(nextReq.id) != null && userReqs.get(nextReq.id) >= userLimit) {
                System.out.println(429);
                System.out.flush();
            } else if (serviceReqs.size() >= serviceLimit) {
                System.out.println(503);
                System.out.flush();
            } else {
                serviceReqs.add(nextReq);
                userReqs.put(nextReq.id, userReqs.get(nextReq.id) == null ? 1L : userReqs.get(nextReq.id) + 1);
                System.out.println(200);
                System.out.flush();
            }
            nextReq = nextReq(s);
        }
    }

    private static void removeExpired(LinkedList<Req> serviceReqs, Map<Long, Long> userReqs, Req nextReq, long duration) {
        Iterator<Req> iterator = serviceReqs.iterator();
        while (iterator.hasNext()) {
            Req oldReq = iterator.next();
            if (nextReq.time - oldReq.time > duration) {
                iterator.remove();
                userReqs.put(oldReq.id, userReqs.get(oldReq.id) - 1);
            } else {
                break;
            }
        }
    }

    private static Req nextReq(Scanner s) {
        long nextLong = s.nextLong();
        if (nextLong == -1) {
            return null;
        }
        return new Req(nextLong, s.nextLong());
    }

    private static class Req {
        long time;
        long id;

        public Req(long time, long id) {
            this.time = time;
            this.id = id;
        }
    }
}
