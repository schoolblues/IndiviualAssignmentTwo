package csc340.assignments;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.Arrays;

@RestController
public class RestApiController {

    String authToken = "NqMfUrViGsITc57+aYkrZzWCdbe2SZiGPt6WAMos1c9W76Kd2Q==--b9unxlUSSSVV370p--akuo/dycemjMs1GsmrTqIw==";

    HttpHeaders headers = new HttpHeaders();
    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    headers.add("Authorization", "Bearer "+authToken);
    /**
     * Information about a specific mod
     * @param modsName
     * @return
     */
    @GetMapping("/mods")
    public Object getMods(@RequestParam(value = "mod_id", defaultValue = "40388")String modsName) {
        try {
            String url = "https://www.nexusmods.com/fallout4/mods/" + modsName;
            RestTemplate restTemplate = new RestTemplate();
            ObjectMapper mapper = new ObjectMapper();

            /**
             * <pre>
             *{
             *    "name": "Appletree Bakery and Creamery - Fruit  - Dairy - Herbs and Spices v9",
             *    "summary": "Fruit and Dairy come to the commonwealth in a BIG WAY. Apples, Cherries, Strawberries - Cheese, Ice Cream, and much more...",
             *    "description": "[center][font=Trebuchet MS][color=#cc4125][size=6][b][img]https://i.imgur.com/LEONUZ7.png[/img]﻿\n<br />﻿\n<br />[img]https://i.imgur.com/YStn5ft.png[/img]\n<br />V 9.1 fixes some minor bugs I found.\n<br />\n<br />V 9.0 is HERE and it brings BREWING SPIRITS to AppleTree Bakery\n<br />\n<br />2 new crops added:[/b]\n<br />Sugarbeet\n<br />Barley\n<br />[b]New Misc Item:\n<br />[/b]Molasses\n<br />[b]2 new furniture:[/b]\n<br />Distillery\n<br />Fermenter\n<br />[b]7 new Alcoholic Spirits:[/b]\n<br />Homemade Beer\n<br />Homemade Mead\n<br />Homemade Moonshine\n<br />Homemade Rum\n<br />Homemade Vodka\n<br />Homemade Whiskey\n<br />Homemade Wine[b]\n<br />\n<br />Brewing is a complicated process!  It involves 3 steps.\n<br />1. Cook up Mash from various sources at a Cooking Station\n<br />2. Store your Mash in the Fermenter for 2 in-game days\n<br />3. Distill your Spirits at the Distillery\n<br />\n<br />\n<br />V 8.0 IS OUT!\n<br />Peanuts and Walnuts!\n<br />Peanut Butter and Jelly!\n<br />Beehives and Honey!\n<br />Bread and Sandwiches!\n<br />Some notes: Beehives will put honey in your workshop.\n<br />I know the grapes look exactly like tarberries.\n<br />Peanuts, Grapes, and Walnuts can be found in the Seed Box.\n<br />Added the [url=https://www.nexusmods.com/fallout4/mods/33895]Hunter's Outpost[/url] That mod is not required.﻿ It now adds meat directly to your workshop.\n<br />\n<br />V 7.5 Fixed Ev-R-Chil and Ice Cream Recipes\n<br />Reduced Ice Cream requirements\n<br />Milk now returns bottles when drunk.\n<br />Cream of Tartar and Crystallized Lactose fixed and craftable.\n<br />\n<br />V 7.4 Fixed Herbs. Removed Milking Station. Just milk cows manually, I guess. I can't get the dang thing working.\n<br />\n<br />V 7.3 Ice cream cones can now be made.\n<br />V 7.2 Minor bugfixes.\n<br />\n<br />Version 7.0 Changes up the pie recipes. I've added Pastry Dough which requires razorgrain, sugar, butter, bicarbonate and cream of tartar. The recipe makes 6 and each pie recipe requires 2 (instead of razorgrain). I've made a couple other minor fixes as well.\n<br />\n<br />Version 6.1 adds in Croissants (+1 Endurance) and Cupcakes (10% better vendor prices). Also, you can now get Rennet (for cheese) from RadStags. Also also,[color=#ffffff] you can now[/color] [color=#ffffff]MILK COWS![/color] Just have an empty milk bottle in your inventory and walk up to a Brahmin.\n<br />\n<br />Version 6.0 Adds in [url=https://www.nexusmods.com/fallout4/mods/51933]Popcorn[/url]﻿! Now with new recipe that uses AppleTree Bakery butter and salt. Also updated the Chocolate Ice Cream recipe to use a [i]special[/i] ingredient, added in a Milkshake recipe, and a few other minor tweaks and bug fixes.\n<br />\n<br />Full contents of the mod:\n<br />\n<br />FRUIT TREES AND SETTLEMENT OBJECTS\n<br />[/b][color=#999999][size=4]Apple Tree\n<br />Pear Tree\n<br />Cherry Tree\n<br />Blueberry Bush\n<br />Strawberry Bush\n<br />All tree and bushes need a fruit and some fertilizer.  The ladder versions require wood.\n<br />They can be assigned to a settler and produce Food for your settlement.  However, the crops the game adds to your Workshop are hardcoded (Corn, mutfruit, etc). So the trees and bushes cannot add apples or blueberries to your Workshop automatically.\n<br />Also in the Resource menu, under Misc, you'll find the Milking Station.  Assign a brahmin or two to it, and it produces milk!  Milk is used in a number of recipes, notably Ice Cream.\n<br />In the food section of Resources, you'll find the SEED BOX, a boost item with 10 of every seed in it. Not really a cheat item, as it is not cheap.\n<br />In the Water menu, you'll find the Desalinator, which produces Salt and Water.\n<br />See below for description of Food Stores - Produces 10 food without any interaction or settler.\n<br />[font=Trebuchet MS][color=#cc4125][size=6][b]\n<br />LEVELED LIST INTEGRATION[/b][/size][/color][/font]\n<br />I've attempted to add the items in this mod to their appropriate vendor and drop lists. This could take a couple of in-game days to show up once the mod/update is installed.\n<br />\n<br />[color=#ff0000][b][size=6]COMPONENTS[/size][/b][/color]\n<br />I've added some new components (like rubber, acid, etc) to this mod to make some of the recipes easier.\n<br />Protein - Your basic food.\n<br />Shortening - A fat or oil used in cooking\n<br />Sugar\n<br />Salt\n<br />(Cream of Tartar) [font=Trebuchet MS][color=#cc4125][size=6][color=#999999][size=4]- Not yet implemented[/size][/color][/size][/color][/font]\n<br />(Bicarbinate) [font=Trebuchet MS][color=#cc4125][size=6][color=#999999][size=4]- Not yet implemented[/size][/color][/size][/color][/font]\n<br />[/size][/color][b]\n<br />\n<br />RECIPES\n<br />[color=#999999][size=4]COOKING STATION\n<br />Apple Pie - Fortify XP\n<br />Cherry Pie - Fortify AP Regen\n<br />Blueberry Pie - Resist Rads\n<br />Strawberry Pie - Fortify Health\n<br />[font=Trebuchet MS][b]Pear Jubilee - Increase Weapon Damage\n<br />Pear Crumble - Fortify Agility and Perception\n<br />Pear-Infused Rum - Gets you drunk\n<br />[/b][/font]Brie Cheese - Fortify Charisma[font=Trebuchet MS][color=#cc4125][size=6][b][color=#999999][size=4] - See Cheese Notes[/size][/color][/b][/size][/color][/font]\n<br />Edam Cheese - Fortify Endurance[font=Trebuchet MS][color=#cc4125][size=6][b][color=#999999][size=4] - See Cheese Notes[/size][/color][/b][/size][/color][/font]\n<br />Hard Apple Cider - Also gets you drunk\n<br />Cider Vinegar - Acid source\n<br />Applesauce - Fortify Charisma\n<br />Milkshake - Fortify Perception by a lot\n<br />Roastin' Ears (Corn on the Cob) - Fortify AP Regen\n<br />Buttered Popcorn - Fortify Charisma, Endurance, and Agility\n<br />Garlic Noodles - Fortify Endurance\n<br />\"Seafood\" Chowder - Water-breathing and Fortify Swim Speed\n<br />Yankee Pot Roast - Requires a lot of materials, but worth it - Heals 400 HP and fortifies health by 200.\n<br />Mince, Stew Meat, Slurry, and Textured Vegetable Protien (see below)\n<br />\n<br />MILK IS GOOD FOR YOUR BONES\n<br />All dairy products give you a PERMANENT 1% reduction in limb damage. Yes, after you eat 100 ice cream cones, you will be immune to limb damage.\n<br />\n<br />CHEM STATION\n<br />ICE CREAM!  Yes, it is made at the chem station, and I'll explain why.\n<br />There's no refrigeration, so how do you keep it cold?\n<br />Why, you need Ev-R-Chil of course! Invented by DANDY INTERNATIONAL before the bombs fell,\n<br />EV-R-CHIL is a non-nutritive, non-toxic additive that can keep food cold for days!\n<br />Fortunately, YOU, the Sole Survivor, know the formula (if you have Chemist! 2)\n<br />One canister of EV-R-CHIL can make one dozen perfectly stable, 3-scoop Ice Cream Cones.\n<br />Chocolate Ice Cream now requires Artificial Flavor, which is also made at the Chem Station.\n<br />Cones are made at the Cooking Station.\n<br />\n<br />CHEESE NOTES\n<br />Cheese is not easy to make, it requires an enzyme to solidify the milk, and one that is most commonly used is called RENNET. Rennet drops from Brahmin and can be bought at junk vendors.\n<br />Brie Recipe make 12 items, Edam recipe makes 5.\n<br />\n<br />MINCE, STEW MEAT, SLURRY, AND TEXTURED VEGETABLE PROTEIN\n<br />All of these can be crafted at the cooking station under their relative categories. \n<br />Meat from anything with a spinal column can make Mince or Stew Meat\n<br />Meat from invertebrates can be made into Slurry\n<br />Basic crop food (corn, razorgrain, etc) can be made into Textured Vegetable Protein\n<br />Some of them can be used in Recipes (Chowder, Yankee Pot Roast) but the main purpose is to unload any extra meat/veggies you have. All four items can be crafted into something called a Food Voucher - Protein 100. \n<br />500 Protein and you can build this:\n<br />[color=#cc4125][size=6][/size][/color][/size][/color][img]https://i.imgur.com/vPCRvJd.jpg[/img]﻿\n<br />\n<br />\n<br />[font=Trebuchet MS][color=#cc4125][size=6][b]\n<br />A big thank you to Drunkykrow for the\n<br />updated textures and models in 2.0!\n<br />And a special shout-out to MacaroniBones,\n<br />my beloved daughter, for helping her\n<br />color-blind mom make textures!\n<br />﻿[/b][/size][/color][/font][/b][/size][/color][/font][/center]",
             *    "picture_url": "https://staticdelivery.nexusmods.com/mods/1151/images/40388/40388-1564839350-820528988.jpeg",
             *    "mod_downloads": 32689,
             *    "mod_unique_downloads": 12994,
             *    "uid": 4943507398084,
             *    "mod_id": 40388,
             *    "game_id": 1151,
             *    "allow_rating": true,
             *    "domain_name": "fallout4",
             *    "category_id": 45,
             *
             *    "version": "9.1",
             *    "endorsement_count": 1557,
             *    "created_timestamp": 1564649968,
             *    "created_time": "2019-08-01T08:59:28.000+00:00",
             *    "updated_timestamp": 1673886251,
             *    "updated_time": "2023-01-16T16:24:11.000+00:00",
             *    "author": "LeahTheUnknown Drunkykrow and MacaroniBones",
             *    "uploaded_by": "LeahTheUnknown",
             *    "uploaded_users_profile_url": "https://www.nexusmods.com/users/10379970",
             *    "contains_adult_content": false,
             *    "status": "published",
             *    "available": true,
             *    "user": {
             *        "member_id": 10379970,
             *        "member_group_id": 27,
             *        "name": "LeahTheUnknown"
             *    },
             *    "endorsement": {
             *        "endorse_status": "Undecided",
             *        "timestamp": null,
             *        "version": null
             *    }
             *}
             * </pre>
             */

            String jsonListResponse = restTemplate.getForObject(url, String.class);
            JsonNode root = mapper.readTree(jsonListResponse);

            Mods mods = new Mods(root.get("summary").asText(), root.get("mod_id").asDouble(),
                    root.get("user").get("name").asText(), root.get("domain_name").asText());
            return mods;
        } catch (JsonProcessingException ex) {
            Logger.getLogger(RestApiController.class.getName()).log(Level.SEVERE,
                    null, ex);
            return "error in /mods";
        }

    }
}