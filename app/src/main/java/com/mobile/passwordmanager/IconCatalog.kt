package com.mobile.passwordmanager

import com.mikepenz.iconics.typeface.IIcon
import com.mikepenz.iconics.typeface.library.simple_icons.SimpleIcons

/**
 * 品牌图标目录,基于离线图标字体库 Simple Icons(com.mikepenz:simple-icons-typeface)。
 *
 * 每个 [IconEntry.key] 是持久化到 [Entry.iconKey] / [Group.iconKey] 的稳定标识,
 * 与 Iconics 的枚举名字保持一致,便于以后按需扩充列表,而不用改动已保存的数据结构。
 */
object IconCatalog {

    data class IconEntry(
        val key: String,
        val label: String,
        val icon: IIcon
    )

    /**
     * 常用网站 / App 品牌图标集合。按字母顺序排列,覆盖社交、邮箱、云盘、支付、开发者工具等常见分类。
     * 需要更多图标时直接在此追加 `IconEntry(...)`,SimpleIcons.Icon 里有 3000+ 品牌可选。
     */
    val all: List<IconEntry> = listOf(
        IconEntry("sim_google", "Google", SimpleIcons.Icon.sim_google),
        IconEntry("sim_icloud", "iCloud", SimpleIcons.Icon.sim_icloud),
        IconEntry("sim_microsoft", "Microsoft", SimpleIcons.Icon.sim_microsoft),
        IconEntry("sim_microsoftoutlook", "Outlook", SimpleIcons.Icon.sim_microsoftoutlook),
        IconEntry("sim_amazon", "Amazon", SimpleIcons.Icon.sim_amazon),
        IconEntry("sim_facebook", "Facebook", SimpleIcons.Icon.sim_facebook),
        IconEntry("sim_instagram", "Instagram", SimpleIcons.Icon.sim_instagram),
        IconEntry("sim_twitter", "X (Twitter)", SimpleIcons.Icon.sim_twitter),
        IconEntry("sim_linkedin", "LinkedIn", SimpleIcons.Icon.sim_linkedin),
        IconEntry("sim_tiktok", "TikTok", SimpleIcons.Icon.sim_tiktok),
        IconEntry("sim_snapchat", "Snapchat", SimpleIcons.Icon.sim_snapchat),
        IconEntry("sim_pinterest", "Pinterest", SimpleIcons.Icon.sim_pinterest),
        IconEntry("sim_reddit", "Reddit", SimpleIcons.Icon.sim_reddit),
        IconEntry("sim_discord", "Discord", SimpleIcons.Icon.sim_discord),
        IconEntry("sim_telegram", "Telegram", SimpleIcons.Icon.sim_telegram),
        IconEntry("sim_whatsapp", "WhatsApp", SimpleIcons.Icon.sim_whatsapp),
        IconEntry("sim_wechat", "微信", SimpleIcons.Icon.sim_wechat),
        IconEntry("sim_alipay", "支付宝", SimpleIcons.Icon.sim_alipay),
        IconEntry("sim_bilibili", "哔哩哔哩", SimpleIcons.Icon.sim_bilibili),
        IconEntry("sim_taobao", "淘宝", SimpleIcons.Icon.sim_taobao),
        IconEntry("sim_netflix", "Netflix", SimpleIcons.Icon.sim_netflix),
        IconEntry("sim_youtube", "YouTube", SimpleIcons.Icon.sim_youtube),
        IconEntry("sim_spotify", "Spotify", SimpleIcons.Icon.sim_spotify),
        IconEntry("sim_github", "GitHub", SimpleIcons.Icon.sim_github),
        IconEntry("sim_gitlab", "GitLab", SimpleIcons.Icon.sim_gitlab),
        IconEntry("sim_bitbucket", "Bitbucket", SimpleIcons.Icon.sim_bitbucket),
        IconEntry("sim_stackoverflow", "Stack Overflow", SimpleIcons.Icon.sim_stackoverflow),
        IconEntry("sim_zoom", "Zoom", SimpleIcons.Icon.sim_zoom),
        IconEntry("sim_notion", "Notion", SimpleIcons.Icon.sim_notion),
        IconEntry("sim_trello", "Trello", SimpleIcons.Icon.sim_trello),
        IconEntry("sim_dropbox", "Dropbox", SimpleIcons.Icon.sim_dropbox),
        IconEntry("sim_googledrive", "Google Drive", SimpleIcons.Icon.sim_googledrive),
        IconEntry("sim_paypal", "PayPal", SimpleIcons.Icon.sim_paypal),
        IconEntry("sim_visa", "Visa", SimpleIcons.Icon.sim_visa),
        IconEntry("sim_mastercard", "Mastercard", SimpleIcons.Icon.sim_mastercard),
        IconEntry("sim_epicgames", "Epic Games", SimpleIcons.Icon.sim_epicgames),
        IconEntry("sim_playstation", "PlayStation", SimpleIcons.Icon.sim_playstation),
        IconEntry("sim_xbox", "Xbox", SimpleIcons.Icon.sim_xbox),
        IconEntry("sim_nintendoswitch", "Nintendo Switch", SimpleIcons.Icon.sim_nintendoswitch),
        IconEntry("sim_airbnb", "Airbnb", SimpleIcons.Icon.sim_airbnb),
        IconEntry("sim_uber", "Uber", SimpleIcons.Icon.sim_uber),
        IconEntry("sim_ebay", "eBay", SimpleIcons.Icon.sim_ebay),
        IconEntry("sim_shopify", "Shopify", SimpleIcons.Icon.sim_shopify),
        IconEntry("sim_wordpress", "WordPress", SimpleIcons.Icon.sim_wordpress),
        IconEntry("sim_evernote", "Evernote", SimpleIcons.Icon.sim_evernote),
        IconEntry("sim_protonmail", "Proton Mail", SimpleIcons.Icon.sim_protonmail),
        IconEntry("sim_tencentqq", "QQ", SimpleIcons.Icon.sim_tencentqq),
        IconEntry("sim_huawei", "华为", SimpleIcons.Icon.sim_huawei),
        IconEntry("sim_xiaomi", "小米", SimpleIcons.Icon.sim_xiaomi),
        IconEntry("sim_samsung", "Samsung", SimpleIcons.Icon.sim_samsung),
        IconEntry("sim_binance", "Binance", SimpleIcons.Icon.sim_binance),
        IconEntry("sim_coinbase", "Coinbase", SimpleIcons.Icon.sim_coinbase),
        IconEntry("sim_americanexpress", "American Express", SimpleIcons.Icon.sim_americanexpress),
        IconEntry("sim_openai", "OpenAI", SimpleIcons.Icon.sim_openai)
    ).sortedBy { it.label }

    private val byKey: Map<String, IconEntry> = all.associateBy { it.key }

    fun find(key: String?): IconEntry? = key?.let { byKey[it] }

    /** 取展示用的图标:有选择则用选择的,否则返回 null 交给调用方使用本地默认 drawable。 */
    fun iconOrNull(key: String?): IIcon? = find(key)?.icon

    /** 按名称做简单的不区分大小写的子串搜索。 */
    fun search(query: String): List<IconEntry> {
        val q = query.trim()
        if (q.isEmpty()) return all
        return all.filter { it.label.contains(q, ignoreCase = true) || it.key.contains(q, ignoreCase = true) }
    }
}
