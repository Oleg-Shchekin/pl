package com.os.security;


import com.os.enums.Role;
import com.os.util.UrlPath;

import java.util.*;

public class SecurityConfig {

    private static final Map<Role, List<String>> mapConfig = new HashMap<>();

    static {
        init();
    }

    private static void init() {

        List<String> readerUrlPatterns = new ArrayList<>();
        readerUrlPatterns.add(UrlPath.READER_PROFILE);
        mapConfig.put(Role.READER, readerUrlPatterns);

        List<String> adminUrlPatterns = new ArrayList<>();
        adminUrlPatterns.add(UrlPath.ADMIN_SHOW_ALL_BOOKS);
        adminUrlPatterns.add(UrlPath.ADMIN_ADD_BOOK);
        adminUrlPatterns.add(UrlPath.ADMIN_EDIT_BOOK);
        mapConfig.put(Role.ADMINISTRATOR, adminUrlPatterns);
    }

    public static Set<Role> getAllRoles(){
        return mapConfig.keySet();
    }

    public static List<String> getAllUrlPatternsForRole(Role role){
        return mapConfig.get(role);
    }
}
