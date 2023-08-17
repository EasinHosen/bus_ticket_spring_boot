package com.kkeb.bus_ticket_flutter.services;

import java.util.List;

import com.kkeb.bus_ticket_flutter.entities.BusRoute;

public interface BusRouteService {
    
    BusRoute addRoute(BusRoute busRoute);

    List<BusRoute> getAllBusRoutes();

    BusRoute getRouteByRouteName(String routeName);

    BusRoute getRouteByCityFromAndCityTo(String cityFrom, String cityTo);
}
