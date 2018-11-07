package com.apap.tutorial6.controller;

import java.util.Optional;

import com.apap.tutorial6.model.PilotModel;
import com.apap.tutorial6.service.PilotService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * PilotController
 */
@Controller
@RequestMapping("/pilot")
public class PilotController {
    @Autowired
    private PilotService pilotService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    private String add(Model model) {
        model.addAttribute("pilot", new PilotModel());
        return "add-pilot";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    private String addPilotSubmit(@ModelAttribute PilotModel pilot) {
        pilotService.addPilot(pilot);
        return "add";
    }

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    private String view(@RequestParam(value = "licenseNumber") String licenseNumber, Model model) {
        Optional<PilotModel> archivePilot = pilotService.getPilotDetailByLicenseNumber(licenseNumber);
        
        model.addAttribute("pilot", archivePilot.get());
        return "view-pilot";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    private String delete(@RequestParam(value = "licenseNumber") String licenseNumber, Model model) {
        pilotService.deletePilotByLicenseNumber(licenseNumber);
        return "delete";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    private String update(@RequestParam(value = "licenseNumber") String licenseNumber, Model model) {
        Optional<PilotModel> archive = pilotService.getPilotDetailByLicenseNumber(licenseNumber);
        model.addAttribute("pilot", archive.get());
        return "update-pilot";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    private @ResponseBody PilotModel updatePilotSubmit(@ModelAttribute PilotModel pilot, Model model) {
        pilotService.addPilot(pilot);
        return pilot;
    }
}