package rmugattarov.yndx.y2021;
//https://contest.yandex.ru/contest/27049/problems
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.*;

import static java.lang.System.out;

public class MarketFeeds {
    public static void main(String[] args) throws ParseException {
        String ex = "2\n" +
                "{\"offers\": [{\"offer_id\": \"offer1\", \"market_sku\": 10846332, \"price\": 1490}, {\"offer_id\": \"offer2\", \"market_sku\": 682644, \"price\": 499}]}\n" +
                "{\"offers\": [{\"offer_id\": \"offer3\", \"market_sku\": 832784, \"price\": 14000}]}\n";

        Scanner s = new Scanner(ex);
        int noOfFeeds = Integer.parseInt(s.nextLine());
        List<Offer> offers = new ArrayList<>();

        while (noOfFeeds-- > 0) {
            offers.addAll(Offer.fromString(s.nextLine().trim()));
        }
        Collections.sort(offers);
        JSONArray jsonArray = new JSONArray();
        for (Offer o: offers) {
            jsonArray.add(o.toJsonObject());
        }
        JSONObject result = new JSONObject();
        result.put("offers", result);
        out.println(result);
    }


    private static class Offer implements Comparable<Offer> {
        private static final JSONParser parser = new JSONParser();
        long price;
        String offerId;
        long marketSku;

        public Offer(long price, String offerId, long marketSku) {
            this.price = price;
            this.offerId = offerId;
            this.marketSku = marketSku;
        }

        public static Collection<Offer> fromString(String s) throws ParseException {
            JSONObject jsonObject = (JSONObject) parser.parse(s);
            JSONArray offers = (JSONArray) jsonObject.get("offers");
            List<Offer> result = new ArrayList<>();
            for(Object o: offers) {
                JSONObject jsonObject1 = (JSONObject) o;
                result.add(new Offer((long) jsonObject1.get("price"), (String) jsonObject1.get("offer_id"), (long) jsonObject1.get("market_sku")));
            }
            return result;
        }

        public JSONObject toJsonObject() {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("market_sku", marketSku);
            jsonObject.put("offer_id", offerId);
            jsonObject.put("price", price);
            return  jsonObject;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Offer offer = (Offer) o;
            return price == offer.price && offerId == offer.offerId;
        }

        @Override
        public int hashCode() {
            return Objects.hash(price, offerId);
        }

        @Override
        public int compareTo(Offer o) {
            if (this.price > o.price) {
                return 1;
            } else if (this.price < o.price) {
                return -1;
            } else {
                return this.offerId.compareTo(o.offerId);
            }
        }
    }
}
