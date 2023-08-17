package com.kkeb.bus_ticket_flutter.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kkeb.bus_ticket_flutter.entities.BusRoute;
import com.kkeb.bus_ticket_flutter.models.ResponseModel;
import com.kkeb.bus_ticket_flutter.services.BusRouteService;

@RestController
@RequestMapping("/api/route")
public class BusRouteController {

    @Autowired
    private BusRouteService busRouteService;

    @PostMapping("/add")
    public ResponseModel<BusRoute> addRoute(@RequestBody BusRoute busRoute) {
        final BusRoute addedRoute = busRouteService.addRoute(busRoute);

        return new ResponseModel<>(HttpStatus.OK.value(), "Bus route added successfully", addedRoute);
    }

    @GetMapping("/all")
    public ResponseModel<List<BusRoute>> getAllRoutes() {
        return new ResponseModel<>(HttpStatus.OK.value(), "Route fetched successfully",
                busRouteService.getAllBusRoutes());
    }

    @GetMapping("/{routeName}")
    public ResponseModel<BusRoute> getRouteByRouteName(@PathVariable(name = "routeName") String routeName) {
        return new ResponseModel<>(HttpStatus.OK.value(), "Route fetched successfully",
                busRouteService.getRouteByRouteName(routeName));

    }

    @GetMapping("/query")
    public ResponseModel<BusRoute> getRouteByCityFromAndCityTo(
            @RequestParam String cityFrom, @RequestParam String cityTo) {
        return new ResponseModel<>(HttpStatus.OK.value(), "Route fetched successfully",
                busRouteService.getRouteByCityFromAndCityTo(cityFrom, cityTo));

    }

}
