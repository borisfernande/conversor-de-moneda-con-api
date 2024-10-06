package com.boris.screenmatch.modelos;

/**
 *
 * @author BORIS
 */
public record MonedaOmdb(String base_code, 
                        String target_code, 
                        double conversion_rate, 
                        double conversion_result) {
    
}
