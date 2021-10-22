package com.testhamza.hamza;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Controller
public class AppController {

    @Autowired
    private ProductService service;
    @Autowired
    private ClientService service1;
    @Autowired
    private SaleService service2;



    @RequestMapping("/new")
    public String showNewProductPage(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);

        return "new_product";
    }
    @RequestMapping("/newclient")
    public String showNewClientPage(Model model) {
        Client client = new Client();
        model.addAttribute("client", client);

        return "new_client";
    }
    @RequestMapping("/newsale")
    public String showNewSalePage(Model model) {
        Sale sale = new Sale();
        model.addAttribute("sale", sale);

        return "new_sale";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit_product");
        Product product = service.get(id);
        mav.addObject("product", product);

        return mav;
    }
    @RequestMapping("/edit1/{id}")
    public ModelAndView showEditClientPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit_client");
        Client client = service1.get(id);
        mav.addObject("client", client);

        return mav;
    }
    @RequestMapping("/edit2/{id}")
    public ModelAndView showEditSalePage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit_sale");
        Sale sale = service2.get(id);
        mav.addObject("sale", sale);

        return mav;
    }
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("product") Product product) {
        service.save(product);

        return "redirect:/";
    }
    @RequestMapping(value = "/save1", method = RequestMethod.POST)
    public String saveClient(@ModelAttribute("client") Client client) {
        service1.save(client);

        return "redirect:/client";
    }
    @RequestMapping(value = "/save2", method = RequestMethod.POST)
    public String saveSale(@ModelAttribute("sale") Sale sale) {
        service2.save(sale);

        return "redirect:/sale";
    }

    @RequestMapping("/")
    public String viewHomePage(Model model){


        List<Product> listProduct = service.listAll();
        model.addAttribute("listProducts",listProduct);
        return "index";

    }
    @RequestMapping("/client")
    public String viewclientPage(Model model){


        List<Client> listClient = service1.listAll();
        model.addAttribute("listClients",listClient);
        return "index1";

    }
    @RequestMapping("/sale")
    public String viewSalePage(Model model){


        List<Sale> listSale = service2.listAll();
        model.addAttribute("listSales",listSale);
        return "index2";

    }
    // handler methods...
    @GetMapping("/checkout")
    public String checkoutOrder(@RequestParam("orderNumber") String saleNumber) {

        List<String> saleStatusList = new ArrayList();
        saleStatusList.clear();
        saleStatusList.add("Complete");

        service2.checkout(saleNumber);

        return "redirect:/sale=" + saleNumber;
    }
}