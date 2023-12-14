//package com.example.Cataloguemicroservice.jms;
//
//public class ProductCatalogJMSMapper {
//    public static ProductCatalogJMSDto MappingProduct(String message) throws MappingException {
//        ObjectMapper objectMapper=new ObjectMapper();
//        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
//        ProductCatalogJMSDto productCatalogJMSDto=null;
//        try {
//            productCatalogJMSDto = objectMapper.readValue(message, ProductCatalogJMSDto.class);
//        }catch (JsonProcessingException e){
//            throw new MappingException("Erreur survenu lors du process de l'objet en JMS Message");
//        }
//        return productCatalogJMSDto;
//    }
//}