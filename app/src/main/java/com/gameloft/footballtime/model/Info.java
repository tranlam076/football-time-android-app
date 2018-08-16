package com.gameloft.footballtime.model;



public class Info {
    private String name;
    private String logoUrl;
    private String manager;
    private String stadium;
    private String capacity;
    private String nickName;

    public Info(String name) {
        this.name = name;
    }

    public Info(String name, String logoUrl, String manager, String stadium, String capacity, String nickName) {
        this.name = name;
        this.logoUrl = logoUrl;
        this.manager = manager;
        this.stadium = stadium;
        this.capacity = capacity;
        this.nickName = nickName;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }
    public void setManager(String manager) {
        this.manager = manager;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getLogo()  {
        switch (name) {
            case "Arsenal FC":
                return "https://upload.wikimedia.org/wikipedia/en/thumb/5/53/Arsenal_FC.svg/323px-Arsenal_FC.svg.png";
            case "AFC Bournemouth":
                return "https://upload.wikimedia.org/wikipedia/en/thumb/e/e5/AFC_Bournemouth_%282013%29.svg/241px-AFC_Bournemouth_%282013%29.svg.png";
            case "Brighton & Hove Albion":
                return "https://upload.wikimedia.org/wikipedia/en/thumb/f/fd/Brighton_%26_Hove_Albion_logo.svg/480px-Brighton_%26_Hove_Albion_logo.svg.png";
            case "Burnley FC":
                return "https://upload.wikimedia.org/wikipedia/en/0/02/Burnley_FC_badge.png";
            case "Chelsea FC":
                return "https://upload.wikimedia.org/wikipedia/en/thumb/c/cc/Chelsea_FC.svg/209px-Chelsea_FC.svg.png";
            case "Crystal Palace FC":
                return "https://upload.wikimedia.org/wikipedia/en/thumb/0/0c/Crystal_Palace_FC_logo.svg/385px-Crystal_Palace_FC_logo.svg.png";
            case "Everton FC":
                return "https://upload.wikimedia.org/wikipedia/en/thumb/7/7c/Everton_FC_logo.svg/325px-Everton_FC_logo.svg.png";
            case "Huddersfield Town":
                return "https://upload.wikimedia.org/wikipedia/en/thumb/5/5a/Huddersfield_Town_A.F.C._logo.svg/218px-Huddersfield_Town_A.F.C._logo.svg.png";
            case "Leicester City FC":
                return "https://upload.wikimedia.org/wikipedia/en/thumb/2/2d/Leicester_City_crest.svg/400px-Leicester_City_crest.svg.png";
            case "Liverpool FC":
                return "https://upload.wikimedia.org/wikipedia/en/thumb/0/0c/Liverpool_FC.svg/370px-Liverpool_FC.svg.png";
            case "Manchester City FC":
                return "https://upload.wikimedia.org/wikipedia/en/thumb/e/eb/Manchester_City_FC_badge.svg/410px-Manchester_City_FC_badge.svg.png";
            case "Manchester United FC":
                return "https://upload.wikimedia.org/wikipedia/en/thumb/7/7a/Manchester_United_FC_crest.svg/296px-Manchester_United_FC_crest.svg.png";
            case "Newcastle United FC":
                return "https://upload.wikimedia.org/wikipedia/en/thumb/5/56/Newcastle_United_Logo.svg/300px-Newcastle_United_Logo.svg.png";
            case "Southampton FC":
                return "https://upload.wikimedia.org/wikipedia/en/thumb/c/c9/FC_Southampton.svg/356px-FC_Southampton.svg.png";
            case "Stoke City FC":
                return "https://upload.wikimedia.org/wikipedia/en/thumb/2/29/Stoke_City_FC.svg/460px-Stoke_City_FC.svg.png";
            case "Swansea City FC":
                return "https://upload.wikimedia.org/wikipedia/en/thumb/f/f9/Swansea_City_AFC_logo.svg/220px-Swansea_City_AFC_logo.svg.png";
            case "Tottenham Hotspur FC":
                return "https://upload.wikimedia.org/wikipedia/en/thumb/b/b4/Tottenham_Hotspur.svg/321px-Tottenham_Hotspur.svg.png";
            case "Watford FC":
                return "https://upload.wikimedia.org/wikipedia/en/thumb/e/e2/Watford.svg/431px-Watford.svg.png";
            case "West Bromwich Albion FC":
                return "https://upload.wikimedia.org/wikipedia/en/thumb/8/8b/West_Bromwich_Albion.svg/586px-West_Bromwich_Albion.svg.png";
            case "West Ham United FC":
                return "https://upload.wikimedia.org/wikipedia/en/thumb/c/c2/West_Ham_United_FC_logo.svg/169px-West_Ham_United_FC_logo.svg.png";
            case "CD Leganes":
                return"https://upload.wikimedia.org/wikipedia/en/0/02/Club_Deportivo_Legan%C3%A9s.png";
            case "Deportivo Alavés":
                return"https://upload.wikimedia.org/wikipedia/en/thumb/2/2e/Deportivo_Alaves_logo.svg/1200px-Deportivo_Alaves_logo.svg.png";
            case "Valencia CF":
                return"https://upload.wikimedia.org/wikipedia/en/thumb/c/ce/Valenciacf.svg/812px-Valenciacf.svg.png";
            case "UD Las Palmas":
                return"https://upload.wikimedia.org/wikipedia/en/thumb/2/20/UD_Las_Palmas_logo.svg/594px-UD_Las_Palmas_logo.svg.png";
            case "RC Celta de Vigo":
                return"https://upload.wikimedia.org/wikipedia/en/thumb/1/12/RC_Celta_de_Vigo_logo.svg/1200px-RC_Celta_de_Vigo_logo.svg.png";
            case "Real Sociedad de Fútbol":
                return"https://upload.wikimedia.org/wikipedia/en/thumb/f/f1/Real_Sociedad_logo.svg/891px-Real_Sociedad_logo.svg.png";
            case "Girona FC":
                return"https://upload.wikimedia.org/wikipedia/en/thumb/9/90/For_article_Girona_FC.svg/1200px-For_article_Girona_FC.svg.png";
            case "Club Atlético de Madrid":
                return"https://upload.wikimedia.org/wikipedia/en/thumb/f/f4/Atletico_Madrid_2017_logo.svg/773px-Atletico_Madrid_2017_logo.svg.png";
            case "Sevilla FC":
                return"http://www.sevillafc.es/sites/default/files/header/image/escudosfc.png";
            case "RCD Espanyol":
                return"https://upload.wikimedia.org/wikipedia/en/thumb/d/d6/Rcd_espanyol_logo.svg/1200px-Rcd_espanyol_logo.svg.png";
            case "Athletic Club":
                return "https://upload.wikimedia.org/wikipedia/en/thumb/9/98/Club_Athletic_Bilbao_logo.svg/903px-Club_Athletic_Bilbao_logo.svg.png";
            case "Getafe CF":
                return "https://upload.wikimedia.org/wikipedia/en/7/7f/Getafe_logo.png";
            case "FC Barcelona":
                return "https://media-public.fcbarcelona.com/20157/0/document_thumbnail/20197/163/163/14590883/1.0-1/14590883.png";
            case "Real Betis":
                return "https://upload.wikimedia.org/wikipedia/en/thumb/1/13/Real_betis_logo.svg/1200px-Real_betis_logo.svg.png";
            case "RC Deportivo La Coruna":
                return "https://upload.wikimedia.org/wikipedia/en/thumb/4/4e/RC_Deportivo_La_Coru%C3%B1a_logo.svg/926px-RC_Deportivo_La_Coru%C3%B1a_logo.svg.png";
            case "Real Madrid CF":
                return "https://upload.wikimedia.org/wikipedia/en/thumb/5/56/Real_Madrid_CF.svg/732px-Real_Madrid_CF.svg.png";
            case "Levante UD":
                return "https://upload.wikimedia.org/wikipedia/en/thumb/7/7b/Levante_Uni%C3%B3n_Deportiva%2C_S.A.D._logo.svg/847px-Levante_Uni%C3%B3n_Deportiva%2C_S.A.D._logo.svg.png";
            case "Villarreal CF":
                return "https://upload.wikimedia.org/wikipedia/en/thumb/7/70/Villarreal_CF_logo.svg/822px-Villarreal_CF_logo.svg.png";
            case "Málaga CF":
                return "https://upload.wikimedia.org/wikipedia/en/thumb/6/6d/M%C3%A1laga_CF.svg/1200px-M%C3%A1laga_CF.svg.png";
            case "SD Eibar":
                return "https://upload.wikimedia.org/wikipedia/en/thumb/3/3b/SD_Eibar_logo_2016.svg/664px-SD_Eibar_logo_2016.svg.png";
            case "FC Bayern München":
                return "https://fcbayern.com/binaries/content/gallery/fc-bayern/logos/bundesliga/480px-logo_fc_bayern_munchen.svg.png";
            case "Bayer Leverkusen":
                return "https://upload.wikimedia.org/wikipedia/en/thumb/5/59/Bayer_04_Leverkusen_logo.svg/1200px-Bayer_04_Leverkusen_logo.svg.png";
            case "Hamburger SV":
                return "https://upload.wikimedia.org/wikipedia/commons/thumb/6/66/HSV-Logo.svg/1200px-HSV-Logo.svg.png";
            case "FC Augsburg":
                return "https://upload.wikimedia.org/wikipedia/en/thumb/c/c5/FC_Augsburg_logo.svg/1200px-FC_Augsburg_logo.svg.png";
            case "Hertha BSC":
                return "https://upload.wikimedia.org/wikipedia/commons/thumb/8/81/Hertha_BSC_Logo_2012.svg/260px-Hertha_BSC_Logo_2012.svg.png";
            case "VfB Stuttgart":
                return "https://upload.wikimedia.org/wikipedia/commons/thumb/e/eb/VfB_Stuttgart_1893_Logo.svg/1200px-VfB_Stuttgart_1893_Logo.svg.png";
            case "TSG 1899 Hoffenheim":
                return "https://upload.wikimedia.org/wikipedia/commons/thumb/e/e7/Logo_TSG_Hoffenheim.svg/170px-Logo_TSG_Hoffenheim.svg.png";
            case "Werder Bremen":
                return "https://upload.wikimedia.org/wikipedia/commons/thumb/b/be/SV-Werder-Bremen-Logo.svg/1200px-SV-Werder-Bremen-Logo.svg.png";
            case "1. FSV Mainz 05":
                return "https://upload.wikimedia.org/wikipedia/en/thumb/7/75/FSV_Mainz_05.svg/1200px-FSV_Mainz_05.svg.png";
            case "Hannover 96":
                return "https://upload.wikimedia.org/wikipedia/commons/thumb/c/cd/Hannover_96_Logo.svg/1200px-Hannover_96_Logo.svg.png";
            case "VfL Wolfsburg":
                return "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f3/Logo-VfL-Wolfsburg.svg/1200px-Logo-VfL-Wolfsburg.svg.png";
            case "Borussia Dortmund":
                return "https://upload.wikimedia.org/wikipedia/commons/thumb/6/67/Borussia_Dortmund_logo.svg/1200px-Borussia_Dortmund_logo.svg.png";
            case "FC Schalke 04":
                return "https://upload.wikimedia.org/wikipedia/commons/thumb/6/6d/FC_Schalke_04_Logo.svg/2000px-FC_Schalke_04_Logo.svg.png";
            case "Red Bull Leipzig":
                return "https://upload.wikimedia.org/wikipedia/en/thumb/0/04/RB_Leipzig_2014_logo.svg/1280px-RB_Leipzig_2014_logo.svg.png";
            case "SC Freiburg":
                return "https://upload.wikimedia.org/wikipedia/en/thumb/6/6d/SC_Freiburg_logo.svg/1200px-SC_Freiburg_logo.svg.png";
            case "Eintracht Frankfurt":
                return "https://upload.wikimedia.org/wikipedia/commons/thumb/0/04/Eintracht_Frankfurt_Logo.svg/1200px-Eintracht_Frankfurt_Logo.svg.png";
            case "Bor. Mönchengladbach":
                return "https://upload.wikimedia.org/wikipedia/commons/thumb/8/81/Borussia_M%C3%B6nchengladbach_logo.svg/1200px-Borussia_M%C3%B6nchengladbach_logo.svg.png";
            case "1. FC Köln":
                return "https://upload.wikimedia.org/wikipedia/en/thumb/5/53/FC_Cologne_logo.svg/901px-FC_Cologne_logo.svg.png";
            case "Juventus Turin":
                return "https://upload.wikimedia.org/wikipedia/commons/thumb/1/15/Juventus_FC_2017_logo.svg/308px-Juventus_FC_2017_logo.svg.png";
            case "Cagliari Calcio":
                return "https://upload.wikimedia.org/wikipedia/en/thumb/6/61/Cagliari_Calcio_1920.svg/1200px-Cagliari_Calcio_1920.svg.png";
            case "Hellas Verona FC":
                return "https://upload.wikimedia.org/wikipedia/en/thumb/c/cc/Hellas_Verona_FC_logo.svg/783px-Hellas_Verona_FC_logo.svg.png";
            case "SSC Napoli":
                return "https://upload.wikimedia.org/wikipedia/commons/thumb/2/28/S.S.C._Napoli_logo.svg/1200px-S.S.C._Napoli_logo.svg.png";
            case "Atalanta BC":
                return "https://upload.wikimedia.org/wikipedia/en/thumb/6/66/AtalantaBC.svg/657px-AtalantaBC.svg.png";
            case "AS Roma":
                return "https://upload.wikimedia.org/wikipedia/en/thumb/5/52/AS_Roma_logo_%282013%29.svg/1200px-AS_Roma_logo_%282013%29.svg.png";
            case "Udinese Calcio":
                return "https://upload.wikimedia.org/wikipedia/en/f/f2/Udinese_calcio.png";
            case "AC Chievo Verona":
                return "https://upload.wikimedia.org/wikipedia/en/4/4a/Chievo-verona-logo.png";
            case "US Sassuolo Calcio":
                return "https://upload.wikimedia.org/wikipedia/en/thumb/1/1c/US_Sassuolo_Calcio_logo.svg/941px-US_Sassuolo_Calcio_logo.svg.png";
            case "Genoa CFC":
                return "https://upload.wikimedia.org/wikipedia/en/4/4e/Genoa_cfc.png";
            case "UC Sampdoria":
                return "https://upload.wikimedia.org/wikipedia/en/f/f7/Sampdoria_badge.png";
            case "Benevento Calcio":
                return "https://upload.wikimedia.org/wikipedia/en/7/74/Benevento_Calcio_logo.png";
            case "SS Lazio":
                return "https://upload.wikimedia.org/wikipedia/en/thumb/e/e4/SS_Lazio.svg/1200px-SS_Lazio.svg.png";
            case "SPAL Ferrara":
                return "https://upload.wikimedia.org/wikipedia/en/thumb/3/3c/Spal2013_logo.svg/1200px-Spal2013_logo.svg.png";
            case "FC Internazionale Milano":
                return "https://upload.wikimedia.org/wikipedia/en/2/23/Inter_Milan.png";
            case "ACF Fiorentina":
                return "https://upload.wikimedia.org/wikipedia/en/thumb/b/ba/ACF_Fiorentina_2.svg/700px-ACF_Fiorentina_2.svg.png";
            case "Bologna FC":
                return "https://upload.wikimedia.org/wikipedia/en/thumb/d/d8/Bolognafc.svg/1200px-Bolognafc.svg.png";
            case "Torino FC":
                return "https://upload.wikimedia.org/wikipedia/en/thumb/2/2e/Torino_FC_Logo.svg/1200px-Torino_FC_Logo.svg.png";
            case "FC Crotone":
                return "https://upload.wikimedia.org/wikipedia/en/2/27/FC_Crotone_Logo.png";
            case "AC Milan":
                return "https://upload.wikimedia.org/wikipedia/commons/thumb/d/db/AC_Milan.svg/1200px-AC_Milan.svg.png";
            case "AS Monaco FC":
                return "https://upload.wikimedia.org/wikipedia/en/thumb/b/ba/AS_Monaco_FC.svg/1200px-AS_Monaco_FC.svg.png";
            case "Toulouse FC":
                return "https://upload.wikimedia.org/wikipedia/en/thumb/5/5d/Toulouse_FC_logo.svg/1024px-Toulouse_FC_logo.svg.png";
            case "Paris Saint-Germain":
                return "https://upload.wikimedia.org/wikipedia/en/thumb/a/a7/Paris_Saint-Germain_F.C..svg/1200px-Paris_Saint-Germain_F.C..svg.png";
            case "Amiens SC":
                return "https://upload.wikimedia.org/wikipedia/en/thumb/f/f6/Amiens_SC_Logo.svg/1200px-Amiens_SC_Logo.svg.png";
            case "ES Troyes AC":
                return "https://upload.wikimedia.org/wikipedia/commons/thumb/b/bf/ES_Troyes_AC.svg/1200px-ES_Troyes_AC.svg.png";
            case "Stade Rennais FC":
                return "https://upload.wikimedia.org/wikipedia/en/thumb/9/9e/Stade_Rennais_FC.svg/927px-Stade_Rennais_FC.svg.png";
            case "AS Saint-Étienne":
                return "https://upload.wikimedia.org/wikipedia/commons/thumb/2/2c/Logo_AS_Saint-%C3%89tienne.svg/1200px-Logo_AS_Saint-%C3%89tienne.svg.png";
            case "OGC Nice":
                return "https://upload.wikimedia.org/wikipedia/en/0/03/OGC_Nice_Logo.png";
            case "Olympique Lyonnais":
                return "https://upload.wikimedia.org/wikipedia/en/thumb/c/c6/Olympique_Lyonnais.svg/883px-Olympique_Lyonnais.svg.png";
            case "RC Strasbourg Alsace":
                return "https://upload.wikimedia.org/wikipedia/en/9/97/Rcstrasbourg.png";
            case "Montpellier Hérault SC":
                return "https://upload.wikimedia.org/wikipedia/commons/3/3c/HSC_Montpellier_Logo.png";
            case "SM Caen":
                return "https://upload.wikimedia.org/wikipedia/en/d/d7/SM_Caen_2016_logo.png";
            case "FC Metz":
                return "https://upload.wikimedia.org/wikipedia/en/thumb/7/71/FC_Metz_logo.svg/894px-FC_Metz_logo.svg.png";
            case "EA Guingamp":
                return "https://upload.wikimedia.org/wikipedia/commons/thumb/2/24/En-Avant-Guingamp-840.png/1200px-En-Avant-Guingamp-840.png";
            case "OSC Lille":
                return "https://upload.wikimedia.org/wikipedia/en/thumb/a/ab/Lille_OSC_logo.svg/1200px-Lille_OSC_logo.svg.png";
            case "FC Nantes":
                return "https://upload.wikimedia.org/wikipedia/en/thumb/2/2b/FC_Nantes_logo.svg/749px-FC_Nantes_logo.svg.png";
            case "Angers SCO":
                return "https://upload.wikimedia.org/wikipedia/en/5/59/Scoangers.png";
            case "FC Girondins de Bordeaux":
                return "https://upload.wikimedia.org/wikipedia/en/thumb/1/11/FC_Girondins_de_Bordeaux_logo.svg/861px-FC_Girondins_de_Bordeaux_logo.svg.png";
            case "Olympique de Marseille":
                return "https://upload.wikimedia.org/wikipedia/en/thumb/8/88/Olympique_de_Marseille_logo.svg/791px-Olympique_de_Marseille_logo.svg.png";
            case "Dijon FCO":
                return "https://upload.wikimedia.org/wikipedia/en/thumb/f/f7/Dijon_FCO_logo.svg/949px-Dijon_FCO_logo.svg.png";
            case "FC Basel":
                return "https://upload.wikimedia.org/wikipedia/commons/thumb/3/30/Logo_FC_Basel.svg/215px-Logo_FC_Basel.svg.png";
            case "CSKA Moscow":
                return "https://upload.wikimedia.org/wikipedia/vi/7/7f/PFK_CSKA_Logo.png";
            case "SL Benfica":
                return "https://upload.wikimedia.org/wikipedia/commons/5/5d/Emblema_Benfica_1930_%28Sem_fundo%29.png";
            case "Celtic FC":
                return "https://upload.wikimedia.org/wikipedia/vi/thumb/a/a8/Celtic_FC.png/601px-Celtic_FC.png";
            case "RSC Anderlecht":
                return "https://upload.wikimedia.org/wikipedia/vi/thumb/7/77/R.S.C._Anderlecht.svg/297px-R.S.C._Anderlecht.svg.png";
            case "Sporting CP":
                return "https://upload.wikimedia.org/wikipedia/vi/3/3e/Sporting_Clube_de_Portugal.png";
            case "Olympiacos F.C.":
                return "https://upload.wikimedia.org/wikipedia/vi/thumb/b/b4/Olympiakos4.svg/565px-Olympiakos4.svg.png";
            case "Feyenoord Rotterdam":
                return "https://upload.wikimedia.org/wikipedia/commons/thumb/9/92/Feyenoord_Rotterdam_FEY.png/600px-Feyenoord_Rotterdam_FEY.png";
            case "Shakhtar Donetsk":
                return "https://upload.wikimedia.org/wikipedia/vi/0/05/Shaxtar_Donetsk.png";
            case "FC Porto":
                return "https://upload.wikimedia.org/wikipedia/vi/9/93/Fcporto.png";
            case "Besiktas JK":
                return "https://upload.wikimedia.org/wikipedia/en/4/47/Besiktas_JK%27s_official_logo.png";
            default:
                return "http://s3.amazonaws.com/i.athcdn.com/assets/images/teams/college-football/logos/200x200/uconn-logo.png";
        }
    }

    public String getStadium() {
        switch (name) {
            case "Arsenal FC":
                return "Emirates Stadium";
            case "AFC Bournemouth":
                return "Dean Court";
            case "Brighton & Hove Albion":
                return "Falmer Stadium";
            case "Burnley FC":
                return "Turf Moor";
            case "Chelsea FC":
                return "Stamford Bridge";
            case "Crystal Palace FC":
                return "Selhurst Park";
            case "Everton FC":
                return "Goodison Park";
            case "Huddersfield Town":
                return "Kirklees Stadium";
            case "Leicester City FC":
                return "King Power";
            case "Liverpool FC":
                return "Anfield";
            case "Manchester City FC":
                return "Etihad";
            case "Manchester United FC":
                return "Old Trafford";
            case "Newcastle United FC":
                return "St James' Park";
            case "Southampton FC":
                return "St Mary's Stadium";
            case "Stoke City FC":
                return "bet365 Stadium";
            case "Swansea City FC":
                return "Liberty Stadium";
            case "Tottenham Hotspur FC":
                return "Wembley Stadium";
            case "Watford FC":
                return "Vicarage Road";
            case "West Bromwich Albion FC":
                return "The Hawthorns Stadium";
            case "West Ham United FC":
                return "London Stadium";
            case "CD Leganes":
                return "Butarque";
            case "Deportivo Alavés":
                return "Mendizorrotza";
            case "Valencia CF":
                return "Mestalla";
            case "UD Las Palmas":
                return "Gran Canaria";
            case "RC Celta de Vigo":
                return "Balaídos";
            case "Real Sociedad de Fútbol":
                return "Anoeta";
            case "Girona FC":
                return "Montilivi";
            case "Club Atlético de Madrid":
                return "Wanda Metropolitano";
            case "Sevilla FC":
                return "Ramón Sánchez Pizjuán";
            case "RCD Espanyol":
                return "RCDE Stadium";
            case "Athletic Club":
                return "San Mamés";
            case "Getafe CF":
                return "Coliseum Alfonso Pérez";
            case "FC Barcelona":
                return "Camp Nou Stadium";
            case "Real Betis":
                return "Villamarín";
            case "RC Deportivo La Coruna":
                return "Abanca-Riazor";
            case "Real Madrid CF":
                return "Santiago Bernabéu";
            case "Levante UD":
                return "Butarque";
            case "Villarreal CF":
                return "Estadio de la Cerámica";
            case "Málaga CF":
                return "La Rosaleda";
            case "SD Eibar":
                return "Ipurua";
            case "FC Bayern München":
                return "Allianz Arena";
            case "Bayer Leverkusen":
                return "BayArena";
            case "Hamburger SV":
                return "Volksparkstadion";
            case "FC Augsburg":
                return "WWK Arena";
            case "Hertha BSC":
                return "Olympiastadion";
            case "VfB Stuttgart":
                return "Mercedes-Benz Arena";
            case "TSG 1899 Hoffenheim":
                return "Wirsol Rhein-Neckar-Arena";
            case "Werder Bremen":
                return "Weser-Stadion";
            case "1. FSV Mainz 05":
                return "Opel Arena";
            case "Hannover 96":
                return "HDI-Arena";
            case "VfL Wolfsburg":
                return "Volkswagen Arena";
            case "Borussia Dortmund":
                return "Signal Iduna Park";
            case "FC Schalke 04":
                return "Veltins-Arena";
            case "Red Bull Leipzig":
                return "Red Bull Arena";
            case "SC Freiburg":
                return "Schwarzwald-Stadion";
            case "Eintracht Frankfurt":
                return "Commerzbank-Arena";
            case "Bor. Mönchengladbach":
                return "Borussia-Park";
            case "1. FC Köln":
                return "RheinEnergieStadion";
            case "Juventus Turin":
                return "Juventus Stadium";
            case "Cagliari Calcio":
                return "Sardegna Arena";
            case "Hellas Verona FC":
                return "Stadio Marc'Antonio Bentegodi";
            case "SSC Napoli":
                return "San Paolo";
            case "Atalanta BC":
                return "Stadio Atleti Azzurri d'Italia";
            case "AS Roma":
                return "Stadio Olimpico";
            case "Udinese Calcio":
                return "Stadio Friuli-Dacia Arena";
            case "AC Chievo Verona":
                return "Stadio Marc'Antonio Bentegodi";
            case "US Sassuolo Calcio":
                return "Mapei Stadium – Città del Tricolore";
            case "Genoa CFC":
                return "Stadio Luigi Ferraris";
            case "UC Sampdoria":
                return "Stadio Luigi Ferraris";
            case "Benevento Calcio":
                return "Stadio Ciro Vigorito";
            case "SS Lazio":
                return "Stadio Olimpico";
            case "SPAL Ferrara":
                return "Paolo Mazza";
            case "FC Internazionale Milano":
                return "San Siro";
            case "ACF Fiorentina":
                return "Stadio Artemio Franchi";
            case "Bologna FC":
                return "Stadio Renato Dall'Ara";
            case "Torino FC":
                return "Stadio Olimpico Grande Torino";
            case "FC Crotone":
                return "Stadio Ezio Scida";
            case "AC Milan":
                return "San Siro";
            case "AS Monaco FC":
                return "Stade Louis II";
            case "Toulouse FC":
                return "Stadium Municipal";
            case "Paris Saint-Germain":
                return "Parc des Princes";
            case "Amiens SC":
                return "Stade de la Licorne";
            case "ES Troyes AC":
                return "Stade de l'Aube";
            case "Stade Rennais FC":
                return "Roazhon Park";
            case "AS Saint-Étienne":
                return "Stade Geoffroy-Guichard";
            case "OGC Nice":
                return "Allianz Riviera";
            case "Olympique Lyonnais":
                return "Groupama Stadium";
            case "RC Strasbourg Alsace":
                return "Stade de la Meinau";
            case "Montpellier Hérault SC":
                return "Stade de la Mosson";
            case "SM Caen":
                return "Stade Michel d'Ornano";
            case "FC Metz":
                return "Stade Saint-Symphorien";
            case "EA Guingamp":
                return "Stade du Roudourou";
            case "OSC Lille":
                return "Stade Pierre-Mauroy";
            case "FC Nantes":
                return "Stade de la Beaujoire";
            case "Angers SCO":
                return "Stade Raymond Kopa";
            case "FC Girondins de Bordeaux":
                return "Matmut Atlantique";
            case "Olympique de Marseille":
                return "Orange Vélodrome";
            case "Dijon FCO":
                return "Stade Gaston Gérard";
            default:
                return "null";
        }
    }

    public String getCapacity()  {
        switch (name) {
            case "Arsenal FC":
                return "60,432";
            case "AFC Bournemouth":
                return "11,360";
            case "Brighton & Hove Albion":
                return "30,750";
            case "Burnley FC":
                return "21,800";
            case "Chelsea FC":
                return "41,631";
            case "Crystal Palace FC":
                return "25,456";
            case "Everton FC":
                return "39,572";
            case "Huddersfield Town":
                return "24,500";
            case "Leicester City FC":
                return "32,315";
            case "Liverpool FC":
                return "54,074";
            case "Manchester City FC":
                return "55,097";
            case "Manchester United FC":
                return "74,994";
            case "Newcastle United FC":
                return "52,354";
            case "Southampton FC":
                return "32,505";
            case "Stoke City FC":
                return "30,089";
            case "Swansea City FC":
                return "21,088";
            case "Tottenham Hotspur FC":
                return "90,000";
            case "Watford FC":
                return "21,438";
            case "West Bromwich Albion FC":
                return "26,852";
            case "West Ham United FC":
                return "60,000";
            case "CD Leganes":
                return"11,454";
            case "Deportivo Alavés":
                return "19,840";
            case "Valencia CF":
                return "55,000";
            case "UD Las Palmas":
                return "33,111";
            case "RC Celta de Vigo":
                return "29,000";
            case "Real Sociedad de Fútbol":
                return"32,000";
            case "Girona FC":
                return "13,500";
            case "Club Atlético de Madrid":
                return "67,703";
            case "Sevilla FC":
                return "42,714";
            case "RCD Espanyol":
                return "40,500";
            case "Athletic Club":
                return "53.289";
            case "Getafe CF":
                return "17,393";
            case "FC Barcelona":
                return "99,354";
            case "Real Betis":
                return "60,720";
            case "RC Deportivo La Coruna":
                return "32,912";
            case "Real Madrid CF":
                return "81,044";
            case "Levante UD":
                return "26,354";
            case "Villarreal CF":
                return "24,890";
            case "Málaga CF":
                return "30,044";
            case "SD Eibar":
                return "7,083";
            case "FC Bayern München":
                return "75,000";
            case "Bayer Leverkusen":
                return "30,210";
            case "Hamburger SV":
                return "57,000";
            case "FC Augsburg":
                return "30,660";
            case "Hertha BSC":
                return "74,475";
            case "VfB Stuttgart":
                return "60,469";
            case "TSG 1899 Hoffenheim":
                return "30,150";
            case "Werder Bremen":
                return "42,100";
            case "1. FSV Mainz 05":
                return "34,034";
            case "Hannover 96":
                return "49,200";
            case "VfL Wolfsburg":
                return "30,000";
            case "Borussia Dortmund":
                return "81,359";
            case "FC Schalke 04":
                return "62,271";
            case "Red Bull Leipzig":
                return "42,959";
            case "SC Freiburg":
                return "24,000";
            case "Eintracht Frankfurt":
                return "51,500";
            case "Bor. Mönchengladbach":
                return "46.287";
            case "1. FC Köln":
                return "49,698";
            case "Juventus Turin":
                return "41,507";
            case "Cagliari Calcio":
                return "16,233";
            case "Hellas Verona FC":
                return "39,371";
            case "SSC Napoli":
                return "60,240";
            case "Atalanta BC":
                return "21,300";
            case "AS Roma":
                return "70,634";
            case "Udinese Calcio":
                return "25,144";
            case "AC Chievo Verona":
                return "39,371";
            case "US Sassuolo Calcio":
                return "23,717";
            case "Genoa CFC":
                return "36,599";
            case "UC Sampdoria":
                return "36,536";
            case "Benevento Calcio":
                return "17,554";
            case "SS Lazio":
                return "70,634";
            case "SPAL Ferrara":
                return "13,020";
            case "FC Internazionale Milano":
                return "80,018";
            case "ACF Fiorentina":
                return "43,147";
            case "Bologna FC":
                return "38,279";
            case "Torino FC":
                return "27,958";
            case "FC Crotone":
                return "16,547";
            case "AC Milan":
                return "80,018";
            case "AS Monaco FC":
                return "18,523";
            case "Toulouse FC":
                return "33,150";
            case "Paris Saint-Germain":
                return "47,929";
            case "Amiens SC":
                return "12,097";
            case "ES Troyes AC":
                return "21,684";
            case "Stade Rennais FC":
                return "29,778";
            case "AS Saint-Étienne":
                return "42,000";
            case "OGC Nice":
                return "35,624";
            case "Olympique Lyonnais":
                return "59,186";
            case "RC Strasbourg Alsace":
                return "29,230";
            case "Montpellier Hérault SC":
                return "32,900";
            case "SM Caen":
                return "21,500";
            case "FC Metz":
                return "25,636";
            case "EA Guingamp":
                return "18,250";
            case "OSC Lille":
                return "50,186";
            case "FC Nantes":
                return "38,128";
            case "Angers SCO":
                return "18,000";
            case "FC Girondins de Bordeaux":
                return "42,000";
            case "Olympique de Marseille":
                return "67,394";
            case "Dijon FCO":
                return "15,995";
            default:
                return "Null";
        }
    }

    public String getManager() {
        switch (name) {
            case "Arsenal FC":
                return "Arsène Wenger";
            case "AFC Bournemouth":
                return "Eddie Howe";
            case "Brighton & Hove Albion":
                return "Chris Hughton";
            case "Burnley FC":
                return "Sean Dyche";
            case "Chelsea FC":
                return "Antonio Conte";
            case "Crystal Palace FC":
                return "Roy Hodgson";
            case "Everton FC":
                return "David Unsworth";
            case "Huddersfield Town":
                return "David Wagner";
            case "Leicester City FC":
                return "Claude Puel";
            case "Liverpool FC":
                return "Jürgen Klopp";
            case "Manchester City FC":
                return "Pep Guardiola";
            case "Manchester United FC":
                return "José Mourinho";
            case "Newcastle United FC":
                return "Rafael Benítez";
            case "Southampton FC":
                return "Mauricio Pellegrino";
            case "Stoke City FC":
                return "Mark Hughes";
            case "Swansea City FC":
                return "Paul Clement";
            case "Tottenham Hotspur FC":
                return "Mauricio Pochettino";
            case "Watford FC":
                return "Marco Silva";
            case "West Bromwich Albion FC":
                return "Tony Pulis";
            case "West Ham United FC":
                return "David Moyes";
            case "CD Leganes":
                return "Asier Garitano";
            case "Deportivo Alavés":
                return "Gianni De Biasi";
            case "Valencia CF":
                return "Marcelino";
            case "UD Las Palmas":
                return "Pako Ayestarán";
            case "RC Celta de Vigo":
                return "Juan Carlos Unzué";
            case "Real Sociedad de Fútbol":
                return "Eusebio Sacristán";
            case "Girona FC":
                return " Pablo Machín";
            case "Club Atlético de Madrid":
                return "Diego Simeone";
            case "Sevilla FC":
                return "Eduardo Berizzo";
            case "RCD Espanyol":
                return "Quique Sánchez Flores";
            case "Athletic Club":
                return "José Ángel Ziganda";
            case "Getafe CF":
                return "José Bordalás";
            case "FC Barcelona":
                return "Ernesto Valverde";
            case "Real Betis":
                return "Quique Setién";
            case "RC Deportivo La Coruna":
                return "Cristóbal Parralo";
            case "Real Madrid CF":
                return "Zinedine Zidane";
            case "Levante UD":
                return "Juan Muñiz";
            case "Villarreal CF":
                return "Javier Calleja";
            case "Málaga CF":
                return "Míchel";
            case "SD Eibar":
                return "José Luis Mendilibar";
            case "FC Bayern München":
                return "Jupp Heynckes";
            case "Bayer Leverkusen":
                return "Heiko Herrlich";
            case "Hamburger SV":
                return "Markus Gisdol";
            case "FC Augsburg":
                return "Manuel Baum";
            case "Hertha BSC":
                return "Pál Dárdai";
            case "VfB Stuttgart":
                return "annes Wolf";
            case "TSG 1899 Hoffenheim":
                return "Julian Nagelsmann";
            case "Werder Bremen":
                return "Florian Kohfeldt";
            case "1. FSV Mainz 05":
                return "Sandro Schwarz";
            case "Hannover 96":
                return "André Breitenreiter";
            case "VfL Wolfsburg":
                return "Martin Schmidt";
            case "Borussia Dortmund":
                return "Peter Bosz";
            case "FC Schalke 04":
                return "Domenico Tedesco";
            case "Red Bull Leipzig":
                return "Ralph Hasenhüttl";
            case "SC Freiburg":
                return "Christian Streich";
            case "Eintracht Frankfurt":
                return "Niko Kovač";
            case "Bor. Mönchengladbach":
                return "Dieter Hecking";
            case "1. FC Köln":
                return "Peter Stöger";
            case "Juventus Turin":
                return "Massimiliano Allegri";
            case "Cagliari Calcio":
                return "Diego López";
            case "Hellas Verona FC":
                return "Fabio Pecchia";
            case "SSC Napoli":
                return "Maurizio Sarri";
            case "Atalanta BC":
                return "Gian Piero Gasperini";
            case "AS Roma":
                return "Eusebio Di Francesco";
            case "Udinese Calcio":
                return "Luigi Delneri";
            case "AC Chievo Verona":
                return "Rolando Maran";
            case "US Sassuolo Calcio":
                return "Cristian Bucchi";
            case "Genoa CFC":
                return "Davide Ballardini";
            case "UC Sampdoria":
                return "Cristian Bucchi";
            case "Benevento Calcio":
                return "Roberto De Zerbi";
            case "SS Lazio":
                return "Simone Inzaghi";
            case "SPAL Ferrara":
                return "Leonardo Semplici";
            case "FC Internazionale Milano":
                return "Luciano Spalletti";
            case "ACF Fiorentina":
                return "Stefano Pioli";
            case "Bologna FC":
                return "Roberto Donadoni";
            case "Torino FC":
                return "Siniša Mihajlović";
            case "FC Crotone":
                return "Davide Nicola";
            case "AC Milan":
                return "Vincenzo Montella";
            case "AS Monaco FC":
                return "Leonardo Jardim";
            case "Toulouse FC":
                return " Pascal Dupraz";
            case "Paris Saint-Germain":
                return "Unai Emery";
            case "Amiens SC":
                return "Christophe Pélissier";
            case "ES Troyes AC":
                return "Jean-Louis Garcia";
            case "Stade Rennais FC":
                return "Sabri Lamouchi";
            case "AS Saint-Étienne":
                return " Julien Sablé";
            case "OGC Nice":
                return "Lucien Favre";
            case "Olympique Lyonnais":
                return "Bruno Génésio";
            case "RC Strasbourg Alsace":
                return "Thierry Laurey";
            case "Montpellier Hérault SC":
                return "Michel Der Zakarian";
            case "SM Caen":
                return "Patrice Garande";
            case "FC Metz":
                return "Frédéric Hantz";
            case "EA Guingamp":
                return "Antoine Kombouaré";
            case "OSC Lille":
                return "Marcelo Bielsa";
            case "FC Nantes":
                return "Claudio Ranieri";
            case "Angers SCO":
                return "Stéphane Moulin";
            case "FC Girondins de Bordeaux":
                return "Jocelyn Gourvennec";
            case "Olympique de Marseille":
                return "Rudi García";
            case "Dijon FCO":
                return "Olivier Dall'Oglio";

            default:
                return "null";
        }
    }



    public String getNickname(){
        switch (name) {
            case "Arsenal FC":
                return "The Gunners";
            case "AFC Bournemouth":
                return "The Cherries";
            case "Brighton & Hove Albion":
                return "The Albion";
            case "Burnley FC":
                return "The Clarets";
            case "Chelsea FC":
                return "The Blues";
            case "Crystal Palace FC":
                return "The Glaziers";
            case "Everton FC":
                return "The Toffees";
            case "Huddersfield Town":
                return "The Terriers";
            case "Leicester City FC":
                return "The Foxes";
            case "Liverpool FC":
                return "The Reds";
            case "Manchester City FC":
                return "The Citizens";
            case "Manchester United FC":
                return "The Red Devils";
            case "Newcastle United FC":
                return "The Magpies";
            case "Southampton FC":
                return "The Saints";
            case "Stoke City FC":
                return "The Potters";
            case "Swansea City FC":
                return "The Swans";
            case "Tottenham Hotspur FC":
                return "The Lilywhites";
            case "Watford FC":
                return "The Hornets";
            case "West Bromwich Albion FC":
                return "The Baggies";
            case "West Ham United FC":
                return "The Hammers";
            case "Valencia CF":
                return "Los Ches";
            case "Real Sociedad de Fútbol":
                return "The Royal";
            case "Club Atlético de Madrid":
                return "The Red and Whites";
            case "Sevilla FC":
                return "The Ones from Nervión";
            case "RCD Espanyol":
                return "The Budgies";
            case "Athletic Club":
                return "The Lions of Saint Mammes";
            case "FC Barcelona":
                return "Els Culers";
            case "Real Madrid CF":
                return "Los Blancos";
            case "Levante UD":
                return "The Frogs";
            case "Villarreal CF":
                return "The Yellow Submarine";
            case "Málaga CF":
                return "The Anchovies";
            case "FC Bayern München":
                return "The Reds";
            case "Bayer Leverkusen":
                return "The Factory XI";
            case "Hamburger SV":
                return "The Dinosaur";
            case "FC Augsburg":
                return "Named after the Fuggers";
            case "Hertha BSC":
                return "The Grand Dame";
            case "TSG 1899 Hoffenheim":
                return "From the Kraichgau region";
            case "VfL Wolfsburg":
                return "Wolves";
            case "Borussia Dortmund":
                return "The Black and Yellows";
            case "FC Schalke 04":
                return "The Miners";
            case "Eintracht Frankfurt":
                return "The Eagles";
            case "Bor. Mönchengladbach":
                return "The Foals";
            case "1. FC Köln":
                return "Billy Goats";
            case "Juventus Turin":
                return "The Old Lady";
            case "Cagliari Calcio":
                return "The Islanders";
            case "SSC Napoli":
                return "The Little Donkeys";
            case "Atalanta BC":
                return "The Goddess";
            case "AS Roma":
                return "The Yellow and Reds";
            case "Udinese Calcio":
                return "The Little Zebras";
            case "AC Chievo Verona":
                return "The Yellow-Blues";
            case "US Sassuolo Calcio":
                return "The Black and Greens";
            case "Genoa CFC":
                return "The Griffin";
            case "UC Sampdoria":
                return "The Blue-Ringed";
            case "SS Lazio":
                return "The White and Sky Blues";
            case "FC Internazionale Milano":
                return "The Cherished Ones";
            case "ACF Fiorentina":
                return "The Purples";
            case "Torino FC":
                return "The Bull";
            case "AC Milan":
                return "Rossoneri";
            case "AS Monaco FC":
                return "The Red and Whites";
            case "Toulouse FC":
                return "The Purples";
            case "Paris Saint-Germain":
                return "The Parisians";
            case "AS Saint-Étienne":
                return "The Greens";
            case "OGC Nice":
                return "The Eaglets";
            case "Olympique Lyonnais":
                return "The Boys";
            case "FC Metz":
                return "The Graoully Dragons";
            case "OSC Lille":
                return "The Mastiffs";
            case "FC Girondins de Bordeaux":
                return "Blue and White";
            case "Olympique de Marseille":
                return "The Phocians";

            default:
                return "Professional Football Club";
        }

    }

}
