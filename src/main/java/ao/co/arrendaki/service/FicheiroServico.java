/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package ao.co.arrendaki.service;

import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author fatin
 */
public interface FicheiroServico {
    
    //Para carregar a foto na app
    public String uploadImage(MultipartFile file); 
}
